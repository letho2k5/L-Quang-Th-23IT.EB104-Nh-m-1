class Fresher extends Employee {
    private String graduationDate;
    private String graduationRank;
    private String education;

    public Fresher(String ID, String fullName, String birthDay, String phone, String email, String employeeType, int employeeCount, String graduationDate, String graduationRank, String education) {
        super(ID, fullName, birthDay, phone, email, employeeType, employeeCount);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Graduation Date: " + graduationDate);
        System.out.println("Graduation Rank: " + graduationRank);
        System.out.println("Education: " + education);
    }
}