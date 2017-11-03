package com.cgi.tpc.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.IntSequenceGenerator;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Access(AccessType.FIELD)
@Table(name = "rfs_def", indexes = {@Index(columnList = "rfsId")})
@JsonIdentityInfo(generator=IntSequenceGenerator.class)
public class RfsDef extends AbstractPersistable<Long> implements Serializable { // NOSONAR

    private static final long serialVersionUID = 8848887579564649636L;

    @Getter
    @Setter
    String name;
    
    @Getter
    @Setter
    @NonNull
    String rfsId;


    @Getter
    @Setter
    @ManyToMany(mappedBy = "rfs")
    List<CfsDef> cfs;
    
    @Getter
    @Setter
    @OneToMany
    List<RfsDef> blockedRfs = new ArrayList<>();

    @JsonIgnore
    @Override
    public boolean isNew() {
        return super.isNew();
    }
}
