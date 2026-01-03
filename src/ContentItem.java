public abstract class ContentItem {
    private int id;
    private static int idGen = 1;
    private String title;
    private int year;
    private int durationMinutes;

    public ContentItem(String title, int year, int duratingMinutes) {
        this.id = idGen++;
        this.title = title;
        this.year = year;
        this.durationMinutes = duratingMinutes;
    }
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public int getYear() {
        return year;
    }
    public int getDurationMinutes() {
        return durationMinutes;
    }
    public void setTitle(String title) {
        if (title == null) {
            throw new IllegalArgumentException("title must not be null/blank");
        }
        this.title = title;
    }

    public void setYear(int year) {
        int currentYear = java.time.Year.now().getValue();
        if (year < 1990 || year > currentYear) {
            throw new IllegalArgumentException("year must be between 1990 and current year");
        }
        this.year = year;
    }

    public void setDurationMinutes(int durationMinutes) {
        if (durationMinutes <= 0) {
            throw new IllegalArgumentException("durationMinutes must be > 0");
        }
        this.durationMinutes = durationMinutes;
    }
    public int getAge(int currentYear) {
        return currentYear - year;
    }
    public abstract double getLicenseCost(int currentYear);

    @Override
    public String toString() {
        return "ContentItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", durationMinutes=" + durationMinutes +
                '}';
    }

}

