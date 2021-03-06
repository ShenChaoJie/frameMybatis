package org.frame.common.format;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;

import org.frame.common.util.ObjectCompare;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

/**
 * 类型转换处理类
 * @author cjshen
 * @since 1.0
 */
public final class ClassCast {
	
	private static final String INTEGER_OBJ = "java.lang.Integer";
	private static final String L_INTEGER_OBJ = "[Ljava.lang.Integer;";//Integer[] Integer数组
	private static final String INT = "int";
	private static final String LONG_OBJ = "java.lang.Long";
	private static final String L_LONG_OBJ = "[Ljava.lang.Long;";//数组
	private static final String LONG = "long";
	private static final String DOUBLE_OBJ = "java.lang.Double";
    private static final String L_DOUBLE_OBJ = "[Ljava.lang.Double;";//数组
    private static final String DOUBLE = "double";
    private static final String FLOAT_OBJ = "java.lang.Float";
    private static final String L_FLOAT_OBJ = "[Ljava.lang.Float;";//数组
    private static final String FLOAT = "float";
    private static final String BOOLEAN_OBJ = "java.lang.Boolean";
    private static final String L_BOOLEAN_OBJ = "[Ljava.lang.Boolean;";//数组
    private static final String BOOLEAN = "boolean";
    private static final String STRING = "java.lang.String";
    private static final String DATE_UTIL = "java.util.Date";
    private static final String DATE_SQL = "java.sql.Date";
    private static final String TIMESTAMP = "java.sql.Timestamp";
    
	private ClassCast() {
		
	}
	
	/**
	 * 转换简单数据类型
	 * @param value 值
	 * @param typeName 类型
	 * @return
	 */
	public static final Object cast(final String value,final String typeName){
		if(value == null){
			return null;
		}
		try {
			switch (typeName) {
			case INTEGER_OBJ:
			case INT:
				return Integer.valueOf(value);
				
			case LONG_OBJ:
			case LONG:
				return Long.valueOf(value);
				
			case DOUBLE_OBJ:
			case DOUBLE:
				return Double.valueOf(value);
				
			case FLOAT_OBJ:
			case FLOAT:
				return Float.valueOf(value);
				
			case BOOLEAN_OBJ:
			case BOOLEAN:
				if(ObjectCompare.isInList(value.toUpperCase(),"1","YES","Y","TRUE")){
					return true;
				}else if(ObjectCompare.isInList(value.toUpperCase(), "0","NO","N","FALSE")){
					return false;
				}else{
					return Boolean.valueOf(value);
				}
				
			case STRING:
				return value;
				
			case DATE_UTIL:
			case DATE_SQL:
				return DateFormat.parse(value, Pattern.DATETIME);
				
			case TIMESTAMP:
				return DateFormat.parse(value, Pattern.TIMESTAMP);
				
			default:
				return JSON.parseObject(value,Class.forName(typeName));
			}
			
		} catch (final ClassCastException | ParseException | ClassNotFoundException e) {
			throw new ClassCastException(e.getMessage(), e);
		}
		
	}
	
	
	 /**
     * 根据Class进行转换，转换简单数据类型
     * @param value 值
     * @param typeName 类型
     * @return 返回转换后的值
     */
	public static final Object cast(final Object value,final String typeName) {
		if(value == null){
			return null;
		}
		if(StringUtils.isEmpty(typeName)){
			throw new IllegalArgumentException("类型名称不能为空");
		}
		
		try {
			switch (typeName) {
				case INTEGER_OBJ:
					if(value instanceof Integer){
						return value;
					}else if (value instanceof BigDecimal){
						return ((BigDecimal) value).intValue();
					}else{
						return new BigDecimal(String.valueOf(value)).intValue();
					}
				case L_INTEGER_OBJ:
					Object[] values = ObjectUtils.toObjectArray(value);
					final Integer[] ints = new Integer[values.length];
					for(int i=0;i<values.length;i++){
						if(values[i] == null || "".equals(values[i])){
							ints[i] = null;
						}else{
							ints[i] = new BigDecimal(String.valueOf(values[i])).intValue();
						}
					}
					return ints;
				case LONG_OBJ:
					if(value instanceof Long){
						return value;
					}else if(value instanceof BigDecimal){
						return ((BigDecimal) value).longValue();
					}else{
						return new BigDecimal(String.valueOf(value)).longValue();
					}
				case L_LONG_OBJ:
					values = ObjectUtils.toObjectArray(value);
					final Long[] longs = new Long[values.length];
					for(int i =0;i<values.length;i++){
						if(longs[i] == null || "".equals(longs[i])){
							longs[i] = null;
						}else{
							longs[i] = new BigDecimal(String.valueOf(values[i])).longValue();
						}
					}
					return longs;
				case DOUBLE_OBJ:
					if(value instanceof Double){
						return value;
					}else if(value instanceof BigDecimal){
						return ((BigDecimal) value).doubleValue();
					}else{
						return new BigDecimal(String.valueOf(value)).doubleValue();
					}
				case L_DOUBLE_OBJ:
					values = ObjectUtils.toObjectArray(value);
					final Double[] doubles = new Double[values.length];
					for(int i=0;i<values.length;i++){
						if(doubles[i] == null || "".equals(doubles[i])){
							doubles[i] = null;
						}else{
							doubles[i] = new BigDecimal(String.valueOf(doubles[i])).doubleValue();
						}
					}
					return doubles;
				case FLOAT_OBJ:
					if(value instanceof Float){
						return value;
					}else if (value instanceof BigDecimal){
						return ((BigDecimal) value).floatValue();
					}else{
						return new BigDecimal(String.valueOf(value)).floatValue();
					}
				case L_FLOAT_OBJ:
					values = ObjectUtils.toObjectArray(value);
					final Float[] floats = new Float[values.length];
					for(int i=0;i<values.length;i++){
						if(floats[i] == null || "".equals(floats[i])){
							floats[i] = null;
						}else{
							floats[i] = new BigDecimal(String.valueOf(values[i])).floatValue();
						}
					}
					return floats;
				case BOOLEAN_OBJ:
					if(value instanceof Boolean){
						return value;
					}else{
						return Boolean.valueOf(String.valueOf(value));
					}
				case L_BOOLEAN_OBJ:
					values = ObjectUtils.toObjectArray(value);
					final Boolean[] booleans = new Boolean[values.length];
					for(int i=0;i<values.length;i++){
						if(booleans[i] == null || "".equals(booleans[i])){
							booleans[i] = null;
						}else{
							booleans[i] = Boolean.valueOf(String.valueOf(values[i]));
						}
					}
				case DATE_UTIL:
				case DATE_SQL:
					if(value instanceof Date){
						return value;
					}else{
						return parseDate(String.valueOf(value));
					}
				case TIMESTAMP:
					if(value instanceof Date){
						return new Timestamp(((Date) value).getTime());
					}else{
						return new Timestamp(parseDate(String.valueOf(value)).getTime());
					}
				case INT:
				case LONG:
				case DOUBLE:
				case FLOAT:
					throw new ClassCastException("只支持对对象数据类型的转换，不支持基本数据类型的转换");
				default:
					String newType;
					if(typeName.startsWith("[L") && typeName.endsWith(";")){
						newType = typeName.substring(2,typeName.length()-1);
					}else{
						newType = typeName;
					}
					if(value instanceof String[]){
						final Class<?> cls = Class.forName(newType);
						final TypeReference<Object> type = new TypeReference<Object>(){
							public Type getType(){
								return cls;
							};
						};
						
						final String[] array = (String[])value;
						final Object[] objs = (Object[]) Array.newInstance(cls, array.length);
						int idx = 0;
						for(String val:array){
							if(String.class == cls){
								objs[idx] = (String)val;
							}else{
								objs[idx] = JSON.parseObject(val,type);
							}
							idx++;
						}
						return objs;
					}else if(value instanceof String){
						final Class<?> cls = Class.forName(typeName);
						if(cls == String.class){
							return value;
						}
						return JSON.parseObject((String)value,cls);
					}
					
					return value;
			}
			
		} catch (final Throwable e) {
			throw new ClassCastException(e.getMessage(), e);
		}
		
	}
	
	
	/**
	 * 将时间字符串 转成 时间对象
	 * @param date 时间格式字符串
	 * @return 时间对象昂
	 * @throws ParseException
	 */
	public static Date parseDate(String date) throws ParseException{
		if(StringUtils.isEmpty(date)){
			return null;
		}
		final String pattern;
		if(date.indexOf(":")>0){
			if(date.indexOf(".")>0){
				pattern = "yyyy-MM-dd HH:mm:ss.SSS";
			}else{
				 pattern = "yyyy-MM-dd HH:mm:ss";
			}
		}else{
			 pattern = "yyyy-MM-dd";
		}
		return DateFormat.parse(date, pattern);
	}
	
	
	

}
