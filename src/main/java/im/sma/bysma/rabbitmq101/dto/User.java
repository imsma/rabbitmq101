package im.sma.bysma.rabbitmq101.dto;

import lombok.Data;

/**
 * User DTO
 */
@Data
public class User {
    // User ID
    private int id;
    // User name
    private String name;
    // User email
    private String email;
}
