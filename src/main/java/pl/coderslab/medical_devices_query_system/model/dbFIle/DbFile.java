package pl.coderslab.medical_devices_query_system.model.dbFIle;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.coderslab.medical_devices_query_system.model.baseEntity.BaseEntity;


import javax.persistence.*;


@Entity
@Table(name = "files")
@Getter
@Setter
@ToString(exclude = "data")
@EqualsAndHashCode(of = "id")
public class DbFile extends BaseEntity {


    @Column(name = "original_file_name")
    private String originalFileName;
    @Column(name = "content_type", nullable = false)
    private String contentType;
    private Long size;
    @Lob
    @Basic(fetch = FetchType.LAZY, optional = false)
    @Column(nullable = false, columnDefinition = "MEDIUMBLOB")
    private byte[] data;




}

