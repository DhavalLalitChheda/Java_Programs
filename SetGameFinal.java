import java.util.*;
class SetGameFinal{
	public static void main(String args[]){
		//take inputs
		Scanner sc = new Scanner(System.in);
		SetGameFinal game = new SetGameFinal();
		System.out.print("Please enter the number of cards: ");
		try {
			int numberOfCards = sc.nextInt();
		
			//Range of cards is from 3-30
			if(numberOfCards < 3 || numberOfCards > 30){
				System.out.println("Please re-reun the program and enter valid number of cards.");
			} else {
				System.out.println("Please enter "+ numberOfCards + " cards");
				System.out.println();
				String[] cards = new String[numberOfCards];
				sc.nextLine();
				for(int i = 1; i <= numberOfCards; i++){
					System.out.println("Please enter " + i + " card");
					cards[i - 1] = sc.nextLine();
				}
				// need to check if cards are valid else display proper message and ask to re-run the program
				if(game.isCardEnteredValid(cards)){
					//create the card deck
					ArrayList<Card> cardDeck = game.createCards(cards);
					System.out.println();
					//get all valid sets
					List<ArrayList<Card>> validSets = game.getAllSets(cardDeck);
					System.out.println("The number of valid sets is/are: " + validSets.size());
					//create a map of all the valid sets to identify the maximum disjointed set
					Map<Integer, ArrayList<Card>> setMap = new HashMap<Integer, ArrayList<Card>>();
					int i = 0;
					for(ArrayList<Card> tempCardList: validSets){
						setMap.put(i, tempCardList);
						i++;
					}

					//get the maximum disjointed set
					List<ArrayList<Card>> disjointedSets = game.getMaximumDisjointedSets(setMap);
					//display size of maximum disjointed set
					System.out.println();
					System.out.println("The size of maximum disjointed set is/are: " + disjointedSets.size());
					System.out.println();
					//display cards involved in the maximum disjointed set
					for(ArrayList<Card> list : disjointedSets){
						for(Card c: list){
							System.out.println(c.getOriginalValue() +" ");
						}
						System.out.println();
					}
				} else {
					//display appropriate message as cards entered are not valid
					System.out.println();
					System.out.println("The cards entered are invalid. Please enter the valid values.");
					System.out.println("The values must be like blue #.(color could be blue, green or yellow followed by a space.)");
					System.out.println("The symbol could be a, s, h, A, S, H, @, # or $");
					System.out.println("The symbols could be entered 1 to 3 times without any space.");
				}
			}

		} catch (InputMismatchException e) {
    		System.err.println("InputMismatchException has occured. Please enter a number between 3 - 30.");
		}	
	}

	//create class of cards
	class Card {
		//
        private int number;
        private String symbol;
        private String shading;
        private String color;
        private String originalValue;
        // set number of card
        public void setNumber(int num){
        	this.number = num;
        }
        // get number of card
        public int getNumber(){
        	return number;
        }
 		// set symbol of card
        public void setSymbol(String s){
        	this.symbol = s;
        }
        //get the symbol of card
        public String getSymbol(){
        	return symbol;
        }
        //set the shading of card
        public void setShading(String s){
        	this.shading = s;
        }
        //get the shading of card
        public String getShading(){
        	return shading;
        }
        //set the color of the card
        public void setColor(String c){
        	this.color = c;
        }
        //get the color of the card
        public String getColor(){
        	return color;
        }
        // set original value of card
        public void setOriginalValue(String s){
        	this.originalValue = s;
        }
        //get the original value of the card
        public String getOriginalValue(){
        	return originalValue;
        }

    }

    //to sort the input of cards received
    class SortByOriginalValue implements Comparator<Card>
	{
		@Override
	    public int compare(Card a, Card b)
	    {
	        return a.getOriginalValue().compareTo(b.getOriginalValue());
	    }
	}

    //create deck of cards
    private ArrayList<Card> createCards(String args[]) {
        ArrayList<Card> cards = new ArrayList<Card>(args.length);
        
        for(int i = 0; i < args.length; i++){
        	Card card = new Card();
        	String[] cardSplit = args[i].split(" ");
        	card.setColor(cardSplit[0]);
        	card.setShading(getCardShade(cardSplit[1]));
        	card.setSymbol(getCardSymbol(cardSplit[1]));
        	card.setNumber(cardSplit[1].length());
        	card.setOriginalValue(args[i]);
        	cards.add(card);
        }
        //need to sort to get maximum disjointed set correctly
        Collections.sort(cards, new SortByOriginalValue());
        return cards;
    }

    //get symbols of cards
    private String getCardSymbol(String card){
    	String symbol;
    	if(card.charAt(0) == 'A' || card.charAt(0) == 'a' || card.charAt(0) == '@'){
    		symbol = "A";
    	} else if(card.charAt(0) == 'S' || card.charAt(0) == 's' || card.charAt(0) == '$'){
    		symbol = "S";
    	} else{
    		symbol = "H";
    	}
    	return symbol;
    }

    //get shade of cards
    private String getCardShade(String card){
    	String shade;
    	if(card.charAt(0) == 'A' || card.charAt(0) == 'S' || card.charAt(0) == 'H'){
    		shade = "upper-case";
    	} else if(card.charAt(0) == 'a' || card.charAt(0) == 's' || card.charAt(0) == 'h'){
    		shade = "lower-case";
    	} else {
    		shade = "symbol-case";
    	}
    	return shade;
    }

    //get all the valid sets
    private List<ArrayList<Card>> getAllSets(List<Card> cards) {
       List<ArrayList<Card>> result = new ArrayList<ArrayList<Card>>();
       int size = cards.size();
       for (int ai = 0; ai < size; ai++) {
           Card a = cards.get(ai);
           for (int bi = ai + 1; bi < size; bi++) {
               Card b = cards.get(bi);
               for (int ci = bi + 1; ci < size; ci++) {
                   Card c = cards.get(ci);
                   if (isSet(a, b, c)) {
                       ArrayList<Card> set = new ArrayList<Card>();
                       set.add(a);
                       set.add(b);
                       set.add(c);
                       result.add(set);
                   }
               }
           }
       }
       return result;
   }

   //to check for valid sets
   private boolean isSet(Card a, Card b, Card c) {
        if (!((a.getNumber() == b.getNumber()) && (b.getNumber() == c.getNumber()) ||
                (a.getNumber() != b.getNumber()) && (a.getNumber() != c.getNumber()) 
                && (b.getNumber() != c.getNumber()))) {
            return false;
        }
        if (!((a.getSymbol().equals(b.getSymbol())) && (b.getSymbol().equals(c.getSymbol())) ||
                !(a.getSymbol().equals(b.getSymbol())) && !(a.getSymbol().equals(c.getSymbol())) 
                && !(b.getSymbol().equals(c.getSymbol())))) {
            return false;
        }
        if (!((a.getShading().equals(b.getShading())) && (b.getShading().equals(c.getShading())) ||
                !(a.getShading().equals(b.getShading())) && !(a.getShading().equals(c.getShading()))
                 && !(b.getShading().equals(c.getShading())))) {
            return false;
        }
        if (!((a.getColor().equals(b.getColor())) && (b.getColor().equals(c.getColor())) ||
                !(a.getColor().equals(b.getColor())) && !(a.getColor().equals(c.getColor()))
                 && !(b.getColor().equals(c.getColor())))) {
            return false;
        }
        return true;
    }

    //get maximum disjointed sets from valid sets
    private List<ArrayList<Card>> getMaximumDisjointedSets(Map<Integer, ArrayList<Card>> setMap) {
    	List<ArrayList<Card>> result = new ArrayList<ArrayList<Card>>();

    	for(int i = 0; i < setMap.size(); i++){
    		List<ArrayList<Card>> tempResult = new ArrayList<ArrayList<Card>>();
    		ArrayList<Card> tempCardList = setMap.get(i);
    		tempResult.add(tempCardList);
    		for(int j = i + 1; j < setMap.size(); j++){
    			
				ArrayList<Card> tempCardList1 = setMap.get(j);
    			boolean flag = true;
    			ArrayList<Card> getCards = getAllCardsFromTempList(tempResult);
				for(Card c : getCards){
					for(Card d : tempCardList1){
						if(c.getOriginalValue().equals(d.getOriginalValue())){
							flag = false;
							break;
						}
					}
				}
    			if(flag){
    				tempResult.add(tempCardList1);
    			}
    			
    		}

    		if(tempResult.size() > result.size()){
    			result = tempResult;
    		}
    	}
    	return result;
    }

    //get all the cards we currently have in the list
    private static ArrayList<Card> getAllCardsFromTempList(List<ArrayList<Card>> cardList){
    	ArrayList<Card> finalCardList = new ArrayList<Card>();
    	
		for(ArrayList<Card> tempList : cardList){
			for(Card c : tempList){
				finalCardList.add(c);
			}
		}
    	
    	return finalCardList;
    }

    //check validity of cards
    private boolean isCardEnteredValid(String[] cards){
    	boolean valid = true;
    	if(checkForDistinctCards(cards)){
    		for(String card : cards){
	    		if(containsNonWhitespaceChar(card)){
	    			String[] input = card.split(" ");
		    		if(checkForInvalidColor(input[0]) || checkForInvalidSymbol(input[1])){
		    			valid = false;
		    			break;
		    		}
	    		} else {
	    			valid = false;
		    		break;
	    		}
	    	}
    	} else{
    		valid = false;
    	}
    	
    	return valid;
    }

    //check if card has invalid color
    private boolean checkForInvalidColor(String color){
    	boolean invalid = false;
    	if(!(color.equals("blue") || color.equals("green") || color.equals("yellow"))){
    		invalid = true;
    	}
    	return invalid;
    }

    //check for invalid symbol and the count
    private boolean checkForInvalidSymbol(String symbol){
    	boolean invalid = false;
    	if(symbol == null || symbol.trim().length() == 0 || 
    		symbol.length() > 3 || isInvalidSymbol(symbol) || checkForInvalidSymbolValue(symbol)){
    		invalid = true;
    	}
    	return invalid;
    }

    //check for symbols greater than length 1, they should be the same.
	private boolean checkForInvalidSymbolValue(String symbol){
    	boolean invalid = false;
    	if(symbol.length() > 1){
    		if(symbol.length() == 2){
    			if(!(symbol.charAt(0) == symbol.charAt(1))){
    				invalid = true;
    			}
    		} else {
    			if(!(symbol.charAt(0) == symbol.charAt(1)) || 
    				!(symbol.charAt(0) == symbol.charAt(2))){
    				invalid = true;
    			}
    		}
    	}
    	return invalid;
    }

    //check if symbol is one of A, S, H, a, s, h, @, #, $
	private boolean isInvalidSymbol(String symbol){
    	boolean invalid = false;
    	if(!(symbol.charAt(0) == 'A' || symbol.charAt(0) == 'S' || symbol.charAt(0) == 'H'
    		|| symbol.charAt(0) == 'a' || symbol.charAt(0) == 's' || symbol.charAt(0) == 'h'
    		|| symbol.charAt(0) == '@' || symbol.charAt(0) == '$' || symbol.charAt(0) == '#')){
    		invalid = true;
    	}
    	return invalid;
    }

    //check if card entered is not null and contains space
    private boolean containsNonWhitespaceChar(String s) {
  		return (s != null) && (s.trim().length() > 0) && (s.contains(" "));
	}

	//check if all the cards are distinct
	private boolean checkForDistinctCards(String[] cards){
		boolean valid = true;
		for(int i = 0; i < cards.length; i++){
			for(int j = i + 1; j < cards.length; j++){
				if(cards[i].equals(cards[j])){
					valid = false;
					break;
				}
			}
		}
		return valid;
	}
}