package co.za.carolsBoutique.ReserveProduct.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @ToString
@AllArgsConstructor
@NoArgsConstructor
public class Reservedproduct {
    private String productCode;
    private String customerEmail;
    private String boutiqueId;
    private LocalDateTime date;
}