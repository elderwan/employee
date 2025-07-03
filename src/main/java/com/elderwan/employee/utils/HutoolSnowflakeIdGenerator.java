package com.elderwan.employee.utils;

import cn.hutool.core.lang.Snowflake;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class HutoolSnowflakeIdGenerator implements IdentifierGenerator {
    private static final Snowflake snowflake = new Snowflake(1, 1);
    
    @Override
    public Long generate(SharedSessionContractImplementor session, Object object)
        throws HibernateException {
        return snowflake.nextId();
    }
}