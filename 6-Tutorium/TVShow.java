public class TVShow {
    private String title;
    private int totalEpisodes;
    private int watchedEpisodes;

    public TVShow(String _title, int _total, int _watched) {
        title = _title; totalEpisodes = _total;
        watchedEpisodes = _watched;
    }
    public void updateTotal(int newTotal) { 
        totalEpisodes = newTotal; 
    }

    public void updateWatched(int newWatched) { 
        watchedEpisodes = newWatched; 
    }
    public String toString() {
        return this.title + ":\n   total Episodes: " +
        this.totalEpisodes + "\n   watched Episodes: " +
        this.watchedEpisodes;
    }
}