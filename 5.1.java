abstract class Shape {
    abstract double area();
}

class Circle extends Shape {
    double r;

    Circle(double r) {
        this.r = r;
    }

    double area() {
        return 3.14 * r * r;
    }
}

class Rectangle extends Shape {
    double l, b;

    Rectangle(double l, double b) {
        this.l = l;
        this.b = b;
    }

    double area() {
        return l * b;
    }
}

class Triangle extends Shape {
    double b, h;

    Triangle(double b, double h) {
        this.b = b;
        this.h = h;
    }

    double area() {
        return 0.5 * b * h;
    }
}

 class Mainn {
    public static void main(String[] args) {

        Shape[] s = {
                new Circle(5),
                new Rectangle(4, 6),
                new Triangle(4, 5)
        };

        double total = 0;

        for (int i = 0; i < s.length; i++) {
            System.out.println("Area = " + s[i].area());
            total = total + s[i].area();
        }

        System.out.println("Total Area = " + total);
    }
}