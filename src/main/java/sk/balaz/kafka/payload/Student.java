package sk.balaz.kafka.payload;

public record Student(
        int id,
        String firstName,
        String lastName
) { }
