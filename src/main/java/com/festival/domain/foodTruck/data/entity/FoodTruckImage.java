package com.festival.domain.foodTruck.data.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
public class FoodTruckImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "main_file_path", nullable = false)
    private String mainFilePath;

    @OneToMany(mappedBy = "image", cascade = CascadeType.REMOVE)
    private List<String> subFilePaths = new ArrayList<>();

    @OneToOne(mappedBy = "foodTruckImage")
    private FoodTruck foodTruck;

    public FoodTruckImage(MultipartFile mainFilePath, List<MultipartFile> subFilePaths) {
        this.mainFilePath = mainFilePath.getName();
        for (MultipartFile subFile : subFilePaths)
            this.subFilePaths.add(subFile.getName());
    }


}
