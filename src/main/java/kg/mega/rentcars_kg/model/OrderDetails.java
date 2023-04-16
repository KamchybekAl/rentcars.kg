package kg.mega.rentcars_kg.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import kg.mega.rentcars_kg.model.enums.GetAddress;
import kg.mega.rentcars_kg.model.enums.ReturnAddress;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_orderdetails")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String car; // ManyToOne
    private Boolean babySeat;
    private Boolean withDriver;
    private String clientName;
    private String clientPhone;
    private String clientEmail;
    @Enumerated(value = EnumType.STRING)
    private GetAddress getAddress;
    @Enumerated(value = EnumType.STRING)
    private ReturnAddress returnAddress;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dateTimeFrom;
    @JsonFormat(pattern = "dd-MM-yyy HH:mm:ss")
    private LocalDateTime dateTimeTo;
    private BigDecimal priceBeforeDiscount;
    private BigDecimal priceWithDiscount;

}
