import java.util.Scanner;

public class Dimensions {
    private int width;
    private int length;
    private int area;
    private int perimeter;
    private int radius;
    private double areaCircle;
    private double circumference;
    private double diameter;
    private char circle_over_rectangle;

    public static void main(String[] args) {
        Dimensions dim = new Dimensions();
        dim.userchoice();
        if (dim.circle_over_rectangle == 'c') {
            dim.main_circle(args);
        } else {
            dim.main_rectangle(args);
        }
    }

    public void main_rectangle(String[] args) {
        Dimensions rectangle = new Dimensions();
        rectangle.store(); // Prompt user to input dimensions
        rectangle.retrieve(); // Calculate properties
        rectangle.print();   // Display results
    }

    public void main_circle(String[] args){
        Dimensions circle = new Dimensions();
        circle.store_circle(); // Prompt user to input radius
        circle.retrieve_circle(); // Calculate properties
        circle.print_circle();   // Display results
    }

    public void store() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter width: ");
        this.width = scanner.nextInt();
        System.out.print("Enter length: ");
        this.length = scanner.nextInt();
        // scanner.close(); // Do not close scanner here
    }

    public void userchoice(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter 'c' for circle or 'r' for rectangle: ");
        this.circle_over_rectangle = scanner.next().charAt(0);
        // scanner.close(); // Do not close scanner here
    }

    public void retrieve() {
        area = width * length;
        perimeter = 2 * (width + length);
    }

    public void print() {
        System.out.println("Width: " + width);
        System.out.println("Length: " + length);
        System.out.println("Area: " + area);
        System.out.println("Perimeter: " + perimeter);
    }

    public void store_circle(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter radius: ");
        this.radius = scanner.nextInt();
        // scanner.close(); // Do not close scanner here
    }
    
    public void retrieve_circle(){
        areaCircle = Math.PI * radius * radius;
        circumference = 2 * Math.PI * radius;
        diameter = 2 * radius;
    }
    public void print_circle() {
        System.out.println("Radius: " + radius);
        System.out.println("Diameter: " + diameter);
        System.out.println("Area: " + areaCircle);
        System.out.println("Perimeter: " + circumference);
    }
}
