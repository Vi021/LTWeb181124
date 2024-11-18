package vn.iostar.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "NAVARCHAR(255")
    private String name;
    @Column(columnDefinition = "NVARCHAR(255)")
    private String brand;
    @Column(columnDefinition = "NVARCHAR(255)")
    private String madein;
    private float price;
}
