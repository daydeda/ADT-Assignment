class studentClass {
    private int position; // Adding position avoiding confusion and checking purpose
    private int sid;
    private String fname;
    private String lname;

    // Constructor
    public studentClass(int position, int sid, String fname, String lname) {
        this.position = position;
        this.sid = sid;
        this.fname = fname;
        this.lname = lname;
    }
    // Adding position avoiding confusion and checking purpose
    // Methods to get student data
    public int getPosition() {
        return position;
    }

    public int getSid() {
        return sid;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }
}
