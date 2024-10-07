public class Kindle {

    private int totalPages;
    private int currentPages;

    public Kindle(){
        totalPages = 0;
        currentPages = 1;

    }// end of default constructor

    public Kindle(int theTotalPages){
        totalPages = theTotalPages;
        currentPages = 1;

    }// end of 1p constructor

    public String toString (){
        return("Page " + currentPages+ "of" + totalPages);

    }// end of toString

    public void turnPages (){
        turnPages(1);



    }// end of turnPages 0p


    public void turnPages (int turnPage){
        if(turnPage < totalPages){
            System.out.println("Turning" + tur);
            currentPages = currentPages + turnPage;
        }



    }// end of turnPage 1p


}// end of the Kindle class
