import Model.*;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args){


        //get count of salary greater than 10000
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1,"Prathmesh","Development",80000,10,LocalDate.of(2022,11,21)));
        employeeList.add(new Employee(2,"Ramesh","QC",70000,9,LocalDate.of(2024,11,21)));
        employeeList.add(new Employee(3,"Suresh","Design",60000,7,LocalDate.of(2026,11,21)));
        employeeList.add(new Employee(4,"Kamlesh","Data",50000,5,LocalDate.of(2026,11,21)));
        employeeList.add(new Employee(5,"Ganesh","Development",40000,2,LocalDate.of(2025,11,21)));
        employeeList.add(new Employee(6,"Dinesh","CSS",30000,1,LocalDate.of(2021,11,21)));
        employeeList.add(new Employee(6,"Kalpesh","Data",30000,1,LocalDate.of(2020,11,21)));
        employeeList.add(new Employee(6,"Vignesh","CSS",30000,1,LocalDate.of(2022,11,21)));

        List<Book> books = Arrays.asList(
                new Book("The Alchemist", "Paulo Coelho", "Fiction", 1988, 20),
                new Book("Atomic Habits", "James Clear", "Self-Help", 2018, 320),
                new Book("Nylon Habits", "James Clear", "Self-Help", 2019, 520),
                new Book("Clean Code", "Robert C. Martin", "Technology", 2008, 464),
                new Book("The Pragmatic Programmer", "Andrew Hunt", "Technology", 1999, 352),
                new Book("Rich Dad Poor Dad", "Robert Kiyosaki", "Finance", 1997, 336),
                new Book("Ikigai", "Hector Garcia", "Self-Help", 2016, 194),
                new Book("Harry Potter", "J.K. Rowling", "Fantasy", 1997, 450),
                new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy", 1937, 310),
                new Book("1984", "George Orwell", "Fiction", 1949, 344),
                new Book("1982", "George Orwell", "Fiction", 1950, 400),
                new Book("1980", "George Orwell", "Fiction", 1952, 111),
                new Book("The Psychology of Money", "Morgan Housel", "Finance", 2020, 256),
                new Book("Effective Java", "Joshua Bloch", "Technology", 2018, 416),
                new Book("Think and Grow Rich", "Napoleon Hill", "Self-Help", 1937, 238),
                new Book("Dune", "Frank Herbert", "Science Fiction", 1965, 688),
                new Book("The Silent Patient", "Alex Michaelides", "Thriller", 2019, 336),
                new Book("Sapiens", "Yuval Noah Harari", "History", 2011, 498)
        );
        List<Transaction> transactions = Arrays.asList(
                new Transaction("T101", 5000, "INR", Type.CREDIT, LocalDate.of(2025, 1, 10)),
                new Transaction("T102", 1500, "INR", Type.DEBIT, LocalDate.of(2025, 1, 12)),
                new Transaction("T103", 2500, "USD", Type.CREDIT, LocalDate.of(2025, 2, 5)),
                new Transaction("T104", 3000, "INR", Type.DEBIT, LocalDate.of(2025, 2, 15)),
                new Transaction("T105", 7500, "INR", Type.CREDIT, LocalDate.of(2025, 3, 1)),
                new Transaction("T106", 1200, "EUR", Type.DEBIT, LocalDate.of(2025, 3, 10)),
                new Transaction("T107", 4500, "USD", Type.CREDIT, LocalDate.of(2025, 4, 5)),
                new Transaction("T108", 2000, "INR", Type.DEBIT, LocalDate.of(2025, 4, 20)),
                new Transaction("T109", 9000, "INR", Type.CREDIT, LocalDate.of(2025, 5, 15)),
                new Transaction("T110", 3500, "EUR", Type.DEBIT, LocalDate.of(2025, 5, 25)),
                new Transaction("T111", 6000, "USD", Type.CREDIT, LocalDate.of(2025, 6, 10)),
                new Transaction("T112", 1800, "INR", Type.DEBIT, LocalDate.of(2025, 6, 20))
        );

        System.out.println(employeeList.stream().filter(e -> e.getSalary()>50000).count());

        ArrayList<String> salaryList = new ArrayList<>(Arrays.asList("300","400","500","600"));
        salaryList.add("333");

//        Stream<Integer> stream = Stream.iterate(1000,(Integer a)-> a*2).limit(30);
//        stream.forEach(System.out::println);

        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("Hello","World"),
                Arrays.asList("Good","Morning"),
                Arrays.asList("Good","Night")
        );

        listOfLists.stream()
                .map(list-> list.stream().map(str -> str.toUpperCase()))
                .forEach(System.out::println);
//                .collect(Collectors.toList());


//        1]Product Analysis:
//        Given a List<Product>, create a Map<String, Double> where the key is the product category and the value is the average price of products in that category.

        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 55000, 10),
                new Product("Mobile", "Electronics", 25000, 25),
                new Product("Headphones", "Accessories", 1500, 50),
                new Product("Keyboard", "Accessories", 2000, 30),
                new Product("Mouse", "Accessories", 800, 100),
                new Product("Chair", "Furniture", 7500, 15),
                new Product("Table", "Furniture", 12000, 8),
                new Product("Monitor", "Electronics", 15000, 20),
                new Product("Watch", "Fashion", 5000, 12),
                new Product("Shoes", "Fashion", 3000, 40)
        );

        Map<String,Double> productAnalysisMap = products.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,Collectors.averagingDouble(Product::getPrice
                        )));
        System.out.println("productAnalysisMap :: "+productAnalysisMap);


//       2]Expensive Products Report:
//       Given a List<Product>, produce a comma-separated string of names of all products that cost more than $100, sorted alphabetically. If no such products exist, return "N/A".

        String expensiveProduct = products.stream()
                .filter(product -> product.getPrice() > 500000)
                .map(product -> product.getName())
                .sorted()
                .collect(Collectors.collectingAndThen(Collectors.joining(", "),result -> result.isEmpty()? "N/A" : result));
        System.out.println("expensiveProduct :: "+expensiveProduct);


        //    Stock Check:
//    Given a List<Product>, find the product with the lowest stock. If multiple products have the same lowest stock, return any one of them. If the list is empty, return an Optional.empty().

        Optional<Product> cheapestProduct = products.stream().min(Comparator.comparing(Product::getPrice));

        System.out.println(cheapestProduct.get());



        List<Order> orders = Arrays.asList(

                new Order("ORD101", Arrays.asList(
                        new OrderItem("P101", 2, 55000),
                        new OrderItem("P102", 1, 25000)
                ), "CUST01"),

                new Order("ORD102", Arrays.asList(
                        new OrderItem("P103", 3, 1500),
                        new OrderItem("P104", 2, 2000)
                ), "CUST02"),

                new Order("ORD103", Arrays.asList(
                        new OrderItem("P101", 1, 55000),
                        new OrderItem("P105", 4, 800)
                ), "CUST01"),

                new Order("ORD104", Arrays.asList(
                        new OrderItem("P106", 2, 7500),
                        new OrderItem("P102", 1, 25000)
                ), "CUST03"),

                new Order("ORD105", Arrays.asList(
                        new OrderItem("P103", 5, 1500),
                        new OrderItem("P105", 3, 800),
                        new OrderItem("P104", 1, 2000)
                ), "CUST02")
        );
        //        Order Value Calculation:
        //        Given a List<Order>, calculate the total value of all orders. (Total value of an order is the sum of quantity * priceAtPurchase for all its OrderItems).

        Optional<Double> sum = orders.stream()
                .flatMap(order -> order.getItem().stream())
                .map(orderItem -> orderItem.getQuantity()*orderItem.getPriceAtPurchase())
                .reduce((a,b)-> a+b);
        System.out.println(sum.get());


    //    Customer Order Summary:
    //    Given a List<Order>, create a Map<String, Integer> where the key is customerId and the value is the total number of items purchased by that customer across all their orders.


    Map<String,Integer> customerOrderSummaryMap = orders.stream()
            .collect(Collectors.groupingBy(order -> order.getCustomerId(),
                    Collectors.summingInt(order -> order.getItem().stream().mapToInt(item -> item.getQuantity()).sum())));


    System.out.println(customerOrderSummaryMap);
        //    Customer Order Total:
        //    Given a List<Order>, create a Map<String, Integer> where the key is customerId and the value is the total sum of items purchased by that customer across all their orders.

        Map<String,Double> customerOrderTotal =  orders.stream()
                .collect(Collectors.groupingBy(order -> order.getCustomerId(),
                        Collectors.summingDouble(order -> order.getItem()
                                .stream()
                                .flatMapToDouble(orderItem -> DoubleStream.of(orderItem.getQuantity() * orderItem.getPriceAtPurchase())).sum())
                )
                );

    System.out.println(customerOrderTotal);

//        Flattening Order Items:
//        Given a List<Order>, create a single List<OrderItem> containing all items from all orders.

    List<OrderItem> allOrders = orders.stream()
            .flatMap(order -> order.getItem().stream())
            .collect(Collectors.toList());
        System.out.println(allOrders);






//        High-Performing Employees:
//        Given a List<Employee>, find the names of all employees who have a salary greater than 70000 and have been with the company for more than 5 years, sorted by salary in descending order.

        String[] highPerformingEmployees = employeeList.stream()
                .filter(employee -> employee.getSalary() > 60000 && employee.getYearsOfService() > 5)
                .sorted((emp1,emp2)->Double.compare(emp2.getSalary(), emp1.getSalary()))
                .map(employee -> employee.getName())
                .toArray(String[]::new);

        System.out.println(Arrays.toString(highPerformingEmployees));



//        Departmental Salary Bill:
//        Given a List<Employee>, calculate the total salary bill for each department, resulting in a Map<String, Double>.

        Map<String,Double> departmentSalaryBill = employeeList.stream()
                .collect(Collectors.groupingBy(employee -> employee.getDepartment(),Collectors.summingDouble(emp->emp.getSalary())));

        System.out.println("departmentSalaryBill \n"+departmentSalaryBill);

//        Most Common Genre:
//        Given a List<Book>, find the genre that has the highest number of books. If there's a tie, any of the top genres will do. Return the genre name as a String.

        String mostBooksGenre = books.stream()
                .collect(Collectors.groupingBy(book -> book.getGenre(),Collectors.counting()))
                .entrySet()
                .stream()
                .peek(System.out::println)
                .max((b1,b2)-> Long.compare(b1.getValue(),b2.getValue()))
                .map(b1->b1.getKey())
                .orElse("N/A");

        System.out.println("mostBooksGenre \n"+mostBooksGenre);

//        Books Published by Year Range:
//        Given a List<Book>, create a Map<Integer, List<String>> where keys are publication years (e.g., 1990, 1991) and values are lists of book titles published in that year, but only include books published between 1980 and 2000 (inclusive).

        Map<Integer,List<String>> bookRangeMap = books.stream()
                .collect(Collectors.groupingBy(book -> book.getPublicationYear(),
                        Collectors.mapping(book -> book.getTitle(),Collectors.toList())));

        System.out.println(bookRangeMap);





        //    Authors and Their Total Pages:
        //    Assume you have a List<Book>. Create a Map<String, Integer> where the key is the authorName and the value is the total number of pages written by that author across all their books in the list.

        Map<String,Integer> authorPagesMap = books.stream()
                .collect(Collectors.groupingBy(book-> book.getAuthorName(),
                        Collectors.summingInt(book -> book.getPages())));


        System.out.println(authorPagesMap);


//        Transaction Summary:
//        Given a List<Transaction>, create a Map<Transaction.Type, Double> that sums the amount for each transaction type (DEBIT, CREDIT).

        Map<Type,Double> transactionSummaryMap = transactions.stream()
                .collect(Collectors.groupingBy(transaction -> transaction.getType(),
                        Collectors.summingDouble(transaction->transaction.getAmount())));

        System.out.println(transactionSummaryMap);


//        Finding "Old" Books:
//        Given a List<Book>, get a list of titles of all books published before 1950, sorted by publication year (oldest first).

        List<String> listOfOldBooks = books.stream()
                .filter(book -> book.getPublicationYear() < 1950)
                .sorted((book1,book2) -> Integer.compare(book1.getPublicationYear(),book2.getPublicationYear()))
                .map(book -> book.getTitle())
                .collect(Collectors.toList());

        System.out.println("listOfOldBooks :: "+listOfOldBooks);

        List<String> listOfOldBooksSortedWay = books.stream()
                .filter(book -> book.getPublicationYear() < 1950)
                .sorted(Comparator.comparingInt(Book::getPublicationYear))
                .map(Book::getTitle)
                .toList();

        System.out.println("listOfOldBooksSortedWay :: "+listOfOldBooksSortedWay);


//        Partitioning Employees by Salary:
//        Given a List<Employee>, partition them into two groups: those earning more than $60,000 and those earning $60,000 or less. The result should be a Map<Boolean, List<Employee>>.

        Map<Boolean,List<Employee>> partitionByEmployeeSal = employeeList.stream()
                .collect(Collectors.partitioningBy(employee -> employee.getSalary()>60000,Collectors.toList()));

        System.out.println("partitionByEmployeeSal :: "+partitionByEmployeeSal);


//        Top N Priciest Products:
//        Given a List<Product> and an integer N, find the N most expensive products. Return them as a List<Product>.

        int productCounts =4;
        List<Product> n_priciestProduct = products.stream()
                .sorted(Comparator.comparingDouble(( Product product)-> product.getPrice()).reversed())
                .limit(productCounts)
                .collect(Collectors.toList());

        System.out.println("n_priciestProduct :: "+n_priciestProduct);

//        Inventory Value by Category:
//        Given a List<Product>, create a Map<String, Double> where the key is the product category and the value is the total inventory value (sum of price * stock for all products in that category).

        Map<String,Double> inventoryValueByCategory = products.stream()
                .collect(Collectors.groupingBy(product -> product.getCategory(),
                        Collectors.summingDouble(product -> generateTotalPrice(product.getPrice(),product.getStock()))));

        System.out.println("inventoryValueByCategory :: "+inventoryValueByCategory);

//        Employees by Joining Year:
//        Given a List<Employee> (assume Employee has a LocalDate joiningDate), group employees by their joining year. The result should be a Map<Integer, List<Employee>>.



        Map<Integer,List<Employee>> employeeByJoiningYear = employeeList.stream()
                .collect(Collectors.groupingBy(emp -> emp.getJoiningDate().getYear(),
                        Collectors.toList()));

        System.out.println("\n\nemployeeByJoiningYear :: "+employeeByJoiningYear);


//        Finding Unique Categories:
//        Given a List<Product>, produce a Set<String> containing all unique product categories.

        Set<String> distinctCategories = products.stream()
                .map(product -> product.getCategory())
//                .distinct()
                .collect(Collectors.toSet());
        System.out.println("\n\ndistinctCategories :: "+distinctCategories);

//        Checking for Product Existence:
//        Given a List<Product> and a String productName, determine if a product with that exact name exists in the list. Return true or false.

        String findProduct ="Monsdfsitor";
        Boolean isProductExist = products.stream()
                .anyMatch(product -> product.getName().equals(findProduct)  );

        System.out.println("isProductExist :: "+isProductExist);


//        Aggregating Book Data:
//        Given a List<Book>, find the author who has written the book with the most pages. If multiple such books/authors exist, return any one of the author's names. Assume each book has only one author for simplicity here.

        Optional<String> author = books.stream()
                .collect(Collectors.groupingBy(Book::getAuthorName,
                        Collectors.maxBy(Comparator.comparingInt(Book::getPages))))
                .entrySet()
                .stream()
                .max((a,b) ->a.getValue().get().getPages() - b.getValue().get().getPages())
                .map(a-> a.getKey())
                .stream().findFirst();


        System.out.println("author :: "+author.get());




    }
        public static double generateTotalPrice(double price,int stock){
            return price*stock;
        }



}
