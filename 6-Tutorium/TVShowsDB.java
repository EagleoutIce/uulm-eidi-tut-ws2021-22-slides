public class TVShowsDB {
    private TVShow[] shows;
    
    public TVShowsDB() {}
    public void addTVShow(TVShow tvShow) {
        if(this.shows == null) this.shows = new TVShow[1];
        else { // Um eins vergrößern und kopieren
            TVShow[] newShows = new TVShow[this.shows.length+1];
            for(int i = 0; i < this.shows.length; i++)
                newShows[i] = this.shows[i];
            this.shows = newShows;
        } // Füge an:
        this.shows[this.shows.length-1] = tvShow;
    }

    public TVShow getTVShow(int index) {
        if (this.shows == null || this.shows.length == 0 ||
              index < 0 || index >= this.shows.length)
            return null; // Fehlerfall
        else return this.shows[index];
    }

    public void removeTVShow(int index) {
        TVShow[] newShows = new TVShow[this.shows.length-1];
        for(int i = 0; i < index; i++) 
            newShows[i] = this.shows[i];
        // Nach Index weiter:
        for(int i = index+1; i < this.shows.length; i++) 
            newShows[i-1] = this.shows[i];
        this.shows=newShows;
    }

    public void printShows() {
        for(int i = 0; i < this.shows.length; i++){
            System.out.println(i + ": " + this.shows[i]);
        }
    }
    
    public static void main(String[] args){
        TVShowsDB database = new TVShowsDB();
        database.addTVShow(new TVShow("Die Piepers",42,10));
        database.addTVShow(new TVShow("Pingu Panther",15,2));
        database.addTVShow(new TVShow("Prince of Eisburg",7,1));
        database.printShows();
        System.out.println();
        database.removeTVShow(2);
        database.getTVShow(1).updateTotal(19);
        database.printShows();
    }

}