package com.cgi.tpc.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "cfs_def", indexes = {@Index(columnList = "cfsId")})
@JsonIdentityInfo(generator=IntSequenceGenerator.class)
public class CfsDef extends AbstractPersistable<Long> implements Serializable { // NOSONAR

    private static final long serialVersionUID = 8848887579564649636L;

    @Getter
    @Setter
    String name;
    
    @Getter
    @Setter
    @NonNull
    String cfsId;

    @Getter
    @Setter
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<RfsDef> rfs;

    @JsonIgnore
    @Override
    public boolean isNew() {
        return super.isNew();
    }
}
