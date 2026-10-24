abstract class Employee {
    String name;
    int id;

    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    abstract double monthlySalary();
}

class FullTime extends Employee {
    double salary;

    FullTime(String n, int i, double s) {
        super(n, i);
        salary = s;
    }

    double monthlySalary() {
        return salary;
    }
}

class PartTime extends Employee {
    int hours;
    double rate;

    PartTime(String n, int i, int h, double r) {
        super(n, i);
        hours = h;
        rate = r;
    }

    double monthlySalary() {
        return hours * rate;
    }
}

class Intern extends Employee {
    double stipend;

    Intern(String n, int i, double s) {
        super(n, i);
        stipend = s;
    }

    double monthlySalary() {
        return stipend;
    }
}

class Test{
    public static void main(String[] args) {

        Employee[] e = {
                new FullTime("A", 1, 50000),
                new PartTime("B", 2, 40, 500),
                new Intern("C", 3, 10000)
        };

        double total = 0;

        for (int i = 0; i < e.length; i++) {
            System.out.println(e[i].name + " = " + e[i].monthlySalary());

            if (e[i] instanceof Intern)
                System.out.println("Intern");

            total += e[i].monthlySalary();
        }

        System.out.println("Total = " + total);
    }
}