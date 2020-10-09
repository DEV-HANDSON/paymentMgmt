package com.atm.demo.util;

import org.dozer.DozerBeanMapper;

public class DozzerMapper {

    private static DozerBeanMapper mapper = new DozerBeanMapper();

    public static <T> T map(Object object1, Class object2) {

        return (T) mapper.map(object1, object2);

    }

}
