package com.li.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author EiletXie
 * @Since 2020/3/9 13:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Provider implements Serializable {

    private Long id;
    private String product;
}