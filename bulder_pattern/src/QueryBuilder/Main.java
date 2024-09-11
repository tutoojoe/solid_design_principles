package QueryBuilder;

public class Main {
    public static void main(String[] args) {
        QueryBuilder query = QueryBuilder.getBuilder()
                .select("id, name")
                .from("students")
                .where("age > 18")
                .orderBy("name")
                .build();

        System.out.println(query);

    }
}
