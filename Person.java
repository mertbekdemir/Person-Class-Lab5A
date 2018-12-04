/**
 * Lab 5A - Person Class.
 *
 * @author Mike Mulder
 * @version 1.0
 */
public class Person
{
    private static final String MALE = "male";
    private static final String FEMALE = "female";
    private static final String HIGH_SCHOOL = "high school";
    private static final String UNDERGRAD = "undergraduate";
    private static final String GRAD = "graduate";
    private static final double LBS_PER_KG = 0.454;
    private static final int    CURRENT_YEAR = 2018;

    private String firstName;
    private String lastName;
    private int birthYear;
    private String sex;
    private double weightPounds;
    private String highestEducationLevel;

    /**
     * @param firstName Person's first name
     * @param lastName Person's last name
     * @param birthYear Person's birth year
     * @param sex Person's sex
     * @param weightPounds Person's weight, in pounds
     * @param highestEducationLevel Person's education level
     */
    public Person(String firstName, String lastName, int birthYear, String sex, double weightPounds, String highestEducationLevel) {

        if (firstName != null) {
            this.firstName = firstName;
        } else {
            throw new IllegalArgumentException("Invalid first name");
        }

        if (lastName != null) {
            this.lastName = lastName;
        } else {
            throw new IllegalArgumentException("Invalid last name");
        }

        if (birthYear > 0 && birthYear < 2018) {
            this.birthYear = birthYear;
        } else {
            throw new IllegalArgumentException("Invalid birth year");
        }

        switch (sex) {
            case MALE:
            case FEMALE:
            this.sex = sex;
            break;
            default:
            throw new IllegalArgumentException("Invalid sex");
        }

        if (weightPounds > 0.0) {
            this.weightPounds = weightPounds;
        } else {
            throw new IllegalArgumentException("Invalid weight");
        }

        switch (highestEducationLevel) {
            case HIGH_SCHOOL:
            case UNDERGRAD:
            case GRAD:
            this.highestEducationLevel = highestEducationLevel;
            break;
            default:
            throw new IllegalArgumentException("Invalid education level");
        }
    }

    /**
     * @param firstName Person's first name
     * @param lastName Person's last name
     * @param sex Person's sex
     * @param weightPounds Person's weight, in pounds
     * @param highestEducationLevel Person's education level
     */
    public Person(String firstName, String lastName, String sex, double weightPounds, String highestEducationLevel) {

        if (firstName != null) {
            this.firstName = firstName;
        } else {
            throw new IllegalArgumentException("Invalid first name");
        }

        if (lastName != null) {
            this.lastName = lastName;
        } else {
            throw new IllegalArgumentException("Invalid last name");
        }

        this.birthYear = 2018;

        switch (sex) {
            case MALE:
            case FEMALE:
            this.sex = sex;
            break;
            default:
            throw new IllegalArgumentException("Invalid sex");
        }

        if (weightPounds > 0.0) {
            this.weightPounds = weightPounds;
        } else {
            throw new IllegalArgumentException("Invalid weight");
        }

        switch (highestEducationLevel) {
            case HIGH_SCHOOL:
            case UNDERGRAD:
            case GRAD:
            this.highestEducationLevel = highestEducationLevel;
            break;
            default:
            throw new IllegalArgumentException("Invalid education level");
        }
    }

    /**
     * @param firstName Person's first name
     * @param lastName Person's last name
     * @param sex Person's sex
     */
    public Person(String firstName, String lastName, double weightPounds) {

        if (firstName != null) {
            this.firstName = firstName;
        } else {
            throw new IllegalArgumentException("Invalid first name");
        }

        if (lastName != null) {
            this.lastName = lastName;
        } else {
            throw new IllegalArgumentException("Invalid last name");
        }
        if (weightPounds > 0.0) {
            this.weightPounds = weightPounds;
        } else {
            throw new IllegalArgumentException("Invalid weight");
        }

        this.birthYear = 2018;
        this.sex = FEMALE;
        this.highestEducationLevel = HIGH_SCHOOL;
    }

    /**
     * Prints the details of a Person
     */
    public void printDetails() {

        System.out.println(firstName + " " + lastName + " was born in " + 
            birthYear + ". " + 
            getHeSheStr(true) + " weighs " + 
            getWeightStr(false) + " and " + 
            getHeSheStr(false) + " has an " + 
            highestEducationLevel + " degree.");        
    }

    /**
     * Prints the details of a Person
     * 
     * @param kilograms Whether to display the weight in kilograms
     */
    public void printDetails(boolean kilograms) {

        System.out.println(firstName + " " + lastName + " was born in " + 
            birthYear + ". " + 
            getHeSheStr(true) + " weighs " + 
            getWeightStr(kilograms) + " and " + 
            getHeSheStr(false) + " has an " + 
            highestEducationLevel + " degree.");        
    }

    /**
     * Prints the details of a Person
     * 
     * @param kilograms Whether to display the weight in kilograms
     * @param uppercase Whether to display the name in uppercase
     */
    public void printDetails(boolean kilograms, boolean upperCase) {

        System.out.println(getNameStr(upperCase) + " was born in " + 
            birthYear + ". " + 
            getHeSheStr(true) + " weighs " + 
            getWeightStr(kilograms) + " and " + 
            getHeSheStr(false) + " has an " + 
            highestEducationLevel + " degree.");        
    }    

    /**
     * Displays the age for each year the Person was alive.
     */
    public void displayAges() {

        int age = 0;
        int year = birthYear;

        while (year <= CURRENT_YEAR) {
            String yearsStr = "years";
            String tenseStr = "was";

            if (age == 1) {
                yearsStr = "year";
            }

            if (year == CURRENT_YEAR) {
                tenseStr = "is";
            }

            System.out.println("In " + year + " " + firstName + " " + lastName + " " + tenseStr + " " + age + " " + yearsStr + " old.");

            age++;
            year++;
        }
    }

    private String getNameStr(boolean uppercase) {
        String name = "";

        if (uppercase) {
            name = firstName.toUpperCase() + " " + lastName.toUpperCase();
        } else {
            name = firstName.toLowerCase() + " " + lastName.toLowerCase();
        }

        return name;
    }

    private String getHeSheStr(boolean initialCaps) {
        String value = "";

        switch (sex) {
            case MALE:
            if (initialCaps) {
                value = "He";
            } else {
                value = "he";
            }
            break;
            case FEMALE:
            if (initialCaps) {
                value = "She";
            } else {
                value = "she";
            }
            break;
            default:
            throw new IllegalArgumentException("Invalid sex");
        }

        return value;
    }

    private String getWeightStr(boolean kilograms) {
        String weightStr = "";

        if (kilograms) {
            double weightKg = weightPounds / LBS_PER_KG;
            weightStr = weightKg + " kilograms";
        } else {
            weightStr = weightPounds + " pounds";
        }

        return weightStr;
    }
}

