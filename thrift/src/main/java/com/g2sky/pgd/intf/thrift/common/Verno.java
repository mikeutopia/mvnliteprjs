/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.g2sky.pgd.intf.thrift.common;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Verno implements org.apache.thrift.TBase<Verno, Verno._Fields>, java.io.Serializable, Cloneable, Comparable<Verno> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Verno");

  private static final org.apache.thrift.protocol.TField YEAR_FIELD_DESC = new org.apache.thrift.protocol.TField("year", org.apache.thrift.protocol.TType.I16, (short)1);
  private static final org.apache.thrift.protocol.TField MONTH_FIELD_DESC = new org.apache.thrift.protocol.TField("month", org.apache.thrift.protocol.TType.BYTE, (short)2);
  private static final org.apache.thrift.protocol.TField DAY_FIELD_DESC = new org.apache.thrift.protocol.TField("day", org.apache.thrift.protocol.TType.BYTE, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new VernoStandardSchemeFactory());
    schemes.put(TupleScheme.class, new VernoTupleSchemeFactory());
  }

  public short year; // required
  public byte month; // required
  public byte day; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    YEAR((short)1, "year"),
    MONTH((short)2, "month"),
    DAY((short)3, "day");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // YEAR
          return YEAR;
        case 2: // MONTH
          return MONTH;
        case 3: // DAY
          return DAY;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __YEAR_ISSET_ID = 0;
  private static final int __MONTH_ISSET_ID = 1;
  private static final int __DAY_ISSET_ID = 2;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.YEAR, new org.apache.thrift.meta_data.FieldMetaData("year", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I16)));
    tmpMap.put(_Fields.MONTH, new org.apache.thrift.meta_data.FieldMetaData("month", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BYTE)));
    tmpMap.put(_Fields.DAY, new org.apache.thrift.meta_data.FieldMetaData("day", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BYTE)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Verno.class, metaDataMap);
  }

  public Verno() {
  }

  public Verno(
    short year,
    byte month,
    byte day)
  {
    this();
    this.year = year;
    setYearIsSet(true);
    this.month = month;
    setMonthIsSet(true);
    this.day = day;
    setDayIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Verno(Verno other) {
    __isset_bitfield = other.__isset_bitfield;
    this.year = other.year;
    this.month = other.month;
    this.day = other.day;
  }

  public Verno deepCopy() {
    return new Verno(this);
  }

  @Override
  public void clear() {
    setYearIsSet(false);
    this.year = 0;
    setMonthIsSet(false);
    this.month = 0;
    setDayIsSet(false);
    this.day = 0;
  }

  public short getYear() {
    return this.year;
  }

  public Verno setYear(short year) {
    this.year = year;
    setYearIsSet(true);
    return this;
  }

  public void unsetYear() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __YEAR_ISSET_ID);
  }

  /** Returns true if field year is set (has been assigned a value) and false otherwise */
  public boolean isSetYear() {
    return EncodingUtils.testBit(__isset_bitfield, __YEAR_ISSET_ID);
  }

  public void setYearIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __YEAR_ISSET_ID, value);
  }

  public byte getMonth() {
    return this.month;
  }

  public Verno setMonth(byte month) {
    this.month = month;
    setMonthIsSet(true);
    return this;
  }

  public void unsetMonth() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __MONTH_ISSET_ID);
  }

  /** Returns true if field month is set (has been assigned a value) and false otherwise */
  public boolean isSetMonth() {
    return EncodingUtils.testBit(__isset_bitfield, __MONTH_ISSET_ID);
  }

  public void setMonthIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __MONTH_ISSET_ID, value);
  }

  public byte getDay() {
    return this.day;
  }

  public Verno setDay(byte day) {
    this.day = day;
    setDayIsSet(true);
    return this;
  }

  public void unsetDay() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __DAY_ISSET_ID);
  }

  /** Returns true if field day is set (has been assigned a value) and false otherwise */
  public boolean isSetDay() {
    return EncodingUtils.testBit(__isset_bitfield, __DAY_ISSET_ID);
  }

  public void setDayIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __DAY_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case YEAR:
      if (value == null) {
        unsetYear();
      } else {
        setYear((Short)value);
      }
      break;

    case MONTH:
      if (value == null) {
        unsetMonth();
      } else {
        setMonth((Byte)value);
      }
      break;

    case DAY:
      if (value == null) {
        unsetDay();
      } else {
        setDay((Byte)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case YEAR:
      return Short.valueOf(getYear());

    case MONTH:
      return Byte.valueOf(getMonth());

    case DAY:
      return Byte.valueOf(getDay());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case YEAR:
      return isSetYear();
    case MONTH:
      return isSetMonth();
    case DAY:
      return isSetDay();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Verno)
      return this.equals((Verno)that);
    return false;
  }

  public boolean equals(Verno that) {
    if (that == null)
      return false;

    boolean this_present_year = true;
    boolean that_present_year = true;
    if (this_present_year || that_present_year) {
      if (!(this_present_year && that_present_year))
        return false;
      if (this.year != that.year)
        return false;
    }

    boolean this_present_month = true;
    boolean that_present_month = true;
    if (this_present_month || that_present_month) {
      if (!(this_present_month && that_present_month))
        return false;
      if (this.month != that.month)
        return false;
    }

    boolean this_present_day = true;
    boolean that_present_day = true;
    if (this_present_day || that_present_day) {
      if (!(this_present_day && that_present_day))
        return false;
      if (this.day != that.day)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(Verno other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetYear()).compareTo(other.isSetYear());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetYear()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.year, other.year);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetMonth()).compareTo(other.isSetMonth());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMonth()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.month, other.month);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDay()).compareTo(other.isSetDay());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDay()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.day, other.day);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Verno(");
    boolean first = true;

    sb.append("year:");
    sb.append(this.year);
    first = false;
    if (!first) sb.append(", ");
    sb.append("month:");
    sb.append(this.month);
    first = false;
    if (!first) sb.append(", ");
    sb.append("day:");
    sb.append(this.day);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class VernoStandardSchemeFactory implements SchemeFactory {
    public VernoStandardScheme getScheme() {
      return new VernoStandardScheme();
    }
  }

  private static class VernoStandardScheme extends StandardScheme<Verno> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Verno struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // YEAR
            if (schemeField.type == org.apache.thrift.protocol.TType.I16) {
              struct.year = iprot.readI16();
              struct.setYearIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // MONTH
            if (schemeField.type == org.apache.thrift.protocol.TType.BYTE) {
              struct.month = iprot.readByte();
              struct.setMonthIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // DAY
            if (schemeField.type == org.apache.thrift.protocol.TType.BYTE) {
              struct.day = iprot.readByte();
              struct.setDayIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, Verno struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(YEAR_FIELD_DESC);
      oprot.writeI16(struct.year);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(MONTH_FIELD_DESC);
      oprot.writeByte(struct.month);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(DAY_FIELD_DESC);
      oprot.writeByte(struct.day);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class VernoTupleSchemeFactory implements SchemeFactory {
    public VernoTupleScheme getScheme() {
      return new VernoTupleScheme();
    }
  }

  private static class VernoTupleScheme extends TupleScheme<Verno> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Verno struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetYear()) {
        optionals.set(0);
      }
      if (struct.isSetMonth()) {
        optionals.set(1);
      }
      if (struct.isSetDay()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetYear()) {
        oprot.writeI16(struct.year);
      }
      if (struct.isSetMonth()) {
        oprot.writeByte(struct.month);
      }
      if (struct.isSetDay()) {
        oprot.writeByte(struct.day);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Verno struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.year = iprot.readI16();
        struct.setYearIsSet(true);
      }
      if (incoming.get(1)) {
        struct.month = iprot.readByte();
        struct.setMonthIsSet(true);
      }
      if (incoming.get(2)) {
        struct.day = iprot.readByte();
        struct.setDayIsSet(true);
      }
    }
  }

}

