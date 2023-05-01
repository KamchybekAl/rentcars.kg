package kg.mega.rentcars_kg.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "orderdetail")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean babySeat;
    private Boolean withDriver;
    private String clientName;
    private String clientPhone;
    private String clientEmail;
    private Double priceBeforeDiscount;
    private Double priceWithDiscount; // Total price
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    private LocalDateTime dateTimeFrom;       На удаление
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    private LocalDateTime dateTimeTo;         На удаление

    @ManyToOne
    @JoinColumn(name = "getAddress",referencedColumnName = "id")
    private Address getAddress;
    @ManyToOne
    @JoinColumn(name = "returnAddress",referencedColumnName = "id")
    private Address returnAddress;
    @ManyToOne
    private Car car;

}
