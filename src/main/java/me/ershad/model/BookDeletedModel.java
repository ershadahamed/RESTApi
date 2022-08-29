package me.ershad.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDeletedModel {
    private Long id;
    private String msg;
    private String title;
}
