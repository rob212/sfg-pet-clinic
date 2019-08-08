package com.woita.sfgpetclinic.model;

import java.io.Serializable;

/**
 * @author mcbrydr on 08/08/19
 */
public class BaseEntity  implements Serializable {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
