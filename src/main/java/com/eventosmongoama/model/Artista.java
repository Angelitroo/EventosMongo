package com.eventosmongoama.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import java.util.List;

@Data
@Document(collection = "artistas")
public class Artista {
    @Id
    private String id;

    @Indexed
    private String nombre;

    @Indexed
    private String generoMusical;

    @Indexed
    private String biografia;

    @Indexed
    private List<String> redesSociales;
}
