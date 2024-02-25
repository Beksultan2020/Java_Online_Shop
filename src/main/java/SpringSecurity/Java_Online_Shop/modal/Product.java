package SpringSecurity.Java_Online_Shop.modal;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product extends BaseModal{
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String   release_date;
    private int price;
    private double mark;//1-Крайне отрицательный, 2-отричательный, 3-смешанный, 4-положительный,5-Крайне положительные

    @Column(columnDefinition = "TEXT")
    private String photo;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Genre> genresList;

    private String publisher;//разработчики(издательство)


}