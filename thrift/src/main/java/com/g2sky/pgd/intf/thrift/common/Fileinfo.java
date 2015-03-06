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

public class Fileinfo implements org.apache.thrift.TBase<Fileinfo, Fileinfo._Fields>, java.io.Serializable, Cloneable, Comparable<Fileinfo> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Fileinfo");

  private static final org.apache.thrift.protocol.TField FILE_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("fileName", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField FILE_PATH_FIELD_DESC = new org.apache.thrift.protocol.TField("filePath", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField CHECKSUM_FIELD_DESC = new org.apache.thrift.protocol.TField("checksum", org.apache.thrift.protocol.TType.BYTE, (short)3);
  private static final org.apache.thrift.protocol.TField LENGTH_FIELD_DESC = new org.apache.thrift.protocol.TField("length", org.apache.thrift.protocol.TType.I64, (short)4);
  private static final org.apache.thrift.protocol.TField VERNO_FIELD_DESC = new org.apache.thrift.protocol.TField("verno", org.apache.thrift.protocol.TType.STRUCT, (short)5);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new FileinfoStandardSchemeFactory());
    schemes.put(TupleScheme.class, new FileinfoTupleSchemeFactory());
  }

  public String fileName; // required
  public String filePath; // required
  public byte checksum; // required
  public long length; // required
  public Verno verno; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    FILE_NAME((short)1, "fileName"),
    FILE_PATH((short)2, "filePath"),
    CHECKSUM((short)3, "checksum"),
    LENGTH((short)4, "length"),
    VERNO((short)5, "verno");

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
        case 1: // FILE_NAME
          return FILE_NAME;
        case 2: // FILE_PATH
          return FILE_PATH;
        case 3: // CHECKSUM
          return CHECKSUM;
        case 4: // LENGTH
          return LENGTH;
        case 5: // VERNO
          return VERNO;
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
  private static final int __CHECKSUM_ISSET_ID = 0;
  private static final int __LENGTH_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.FILE_NAME, new org.apache.thrift.meta_data.FieldMetaData("fileName", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.FILE_PATH, new org.apache.thrift.meta_data.FieldMetaData("filePath", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.CHECKSUM, new org.apache.thrift.meta_data.FieldMetaData("checksum", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BYTE)));
    tmpMap.put(_Fields.LENGTH, new org.apache.thrift.meta_data.FieldMetaData("length", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.VERNO, new org.apache.thrift.meta_data.FieldMetaData("verno", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, Verno.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Fileinfo.class, metaDataMap);
  }

  public Fileinfo() {
  }

  public Fileinfo(
    String fileName,
    String filePath,
    byte checksum,
    long length,
    Verno verno)
  {
    this();
    this.fileName = fileName;
    this.filePath = filePath;
    this.checksum = checksum;
    setChecksumIsSet(true);
    this.length = length;
    setLengthIsSet(true);
    this.verno = verno;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Fileinfo(Fileinfo other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetFileName()) {
      this.fileName = other.fileName;
    }
    if (other.isSetFilePath()) {
      this.filePath = other.filePath;
    }
    this.checksum = other.checksum;
    this.length = other.length;
    if (other.isSetVerno()) {
      this.verno = new Verno(other.verno);
    }
  }

  public Fileinfo deepCopy() {
    return new Fileinfo(this);
  }

  @Override
  public void clear() {
    this.fileName = null;
    this.filePath = null;
    setChecksumIsSet(false);
    this.checksum = 0;
    setLengthIsSet(false);
    this.length = 0;
    this.verno = null;
  }

  public String getFileName() {
    return this.fileName;
  }

  public Fileinfo setFileName(String fileName) {
    this.fileName = fileName;
    return this;
  }

  public void unsetFileName() {
    this.fileName = null;
  }

  /** Returns true if field fileName is set (has been assigned a value) and false otherwise */
  public boolean isSetFileName() {
    return this.fileName != null;
  }

  public void setFileNameIsSet(boolean value) {
    if (!value) {
      this.fileName = null;
    }
  }

  public String getFilePath() {
    return this.filePath;
  }

  public Fileinfo setFilePath(String filePath) {
    this.filePath = filePath;
    return this;
  }

  public void unsetFilePath() {
    this.filePath = null;
  }

  /** Returns true if field filePath is set (has been assigned a value) and false otherwise */
  public boolean isSetFilePath() {
    return this.filePath != null;
  }

  public void setFilePathIsSet(boolean value) {
    if (!value) {
      this.filePath = null;
    }
  }

  public byte getChecksum() {
    return this.checksum;
  }

  public Fileinfo setChecksum(byte checksum) {
    this.checksum = checksum;
    setChecksumIsSet(true);
    return this;
  }

  public void unsetChecksum() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __CHECKSUM_ISSET_ID);
  }

  /** Returns true if field checksum is set (has been assigned a value) and false otherwise */
  public boolean isSetChecksum() {
    return EncodingUtils.testBit(__isset_bitfield, __CHECKSUM_ISSET_ID);
  }

  public void setChecksumIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __CHECKSUM_ISSET_ID, value);
  }

  public long getLength() {
    return this.length;
  }

  public Fileinfo setLength(long length) {
    this.length = length;
    setLengthIsSet(true);
    return this;
  }

  public void unsetLength() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __LENGTH_ISSET_ID);
  }

  /** Returns true if field length is set (has been assigned a value) and false otherwise */
  public boolean isSetLength() {
    return EncodingUtils.testBit(__isset_bitfield, __LENGTH_ISSET_ID);
  }

  public void setLengthIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __LENGTH_ISSET_ID, value);
  }

  public Verno getVerno() {
    return this.verno;
  }

  public Fileinfo setVerno(Verno verno) {
    this.verno = verno;
    return this;
  }

  public void unsetVerno() {
    this.verno = null;
  }

  /** Returns true if field verno is set (has been assigned a value) and false otherwise */
  public boolean isSetVerno() {
    return this.verno != null;
  }

  public void setVernoIsSet(boolean value) {
    if (!value) {
      this.verno = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case FILE_NAME:
      if (value == null) {
        unsetFileName();
      } else {
        setFileName((String)value);
      }
      break;

    case FILE_PATH:
      if (value == null) {
        unsetFilePath();
      } else {
        setFilePath((String)value);
      }
      break;

    case CHECKSUM:
      if (value == null) {
        unsetChecksum();
      } else {
        setChecksum((Byte)value);
      }
      break;

    case LENGTH:
      if (value == null) {
        unsetLength();
      } else {
        setLength((Long)value);
      }
      break;

    case VERNO:
      if (value == null) {
        unsetVerno();
      } else {
        setVerno((Verno)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case FILE_NAME:
      return getFileName();

    case FILE_PATH:
      return getFilePath();

    case CHECKSUM:
      return Byte.valueOf(getChecksum());

    case LENGTH:
      return Long.valueOf(getLength());

    case VERNO:
      return getVerno();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case FILE_NAME:
      return isSetFileName();
    case FILE_PATH:
      return isSetFilePath();
    case CHECKSUM:
      return isSetChecksum();
    case LENGTH:
      return isSetLength();
    case VERNO:
      return isSetVerno();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Fileinfo)
      return this.equals((Fileinfo)that);
    return false;
  }

  public boolean equals(Fileinfo that) {
    if (that == null)
      return false;

    boolean this_present_fileName = true && this.isSetFileName();
    boolean that_present_fileName = true && that.isSetFileName();
    if (this_present_fileName || that_present_fileName) {
      if (!(this_present_fileName && that_present_fileName))
        return false;
      if (!this.fileName.equals(that.fileName))
        return false;
    }

    boolean this_present_filePath = true && this.isSetFilePath();
    boolean that_present_filePath = true && that.isSetFilePath();
    if (this_present_filePath || that_present_filePath) {
      if (!(this_present_filePath && that_present_filePath))
        return false;
      if (!this.filePath.equals(that.filePath))
        return false;
    }

    boolean this_present_checksum = true;
    boolean that_present_checksum = true;
    if (this_present_checksum || that_present_checksum) {
      if (!(this_present_checksum && that_present_checksum))
        return false;
      if (this.checksum != that.checksum)
        return false;
    }

    boolean this_present_length = true;
    boolean that_present_length = true;
    if (this_present_length || that_present_length) {
      if (!(this_present_length && that_present_length))
        return false;
      if (this.length != that.length)
        return false;
    }

    boolean this_present_verno = true && this.isSetVerno();
    boolean that_present_verno = true && that.isSetVerno();
    if (this_present_verno || that_present_verno) {
      if (!(this_present_verno && that_present_verno))
        return false;
      if (!this.verno.equals(that.verno))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(Fileinfo other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetFileName()).compareTo(other.isSetFileName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFileName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.fileName, other.fileName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetFilePath()).compareTo(other.isSetFilePath());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFilePath()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.filePath, other.filePath);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetChecksum()).compareTo(other.isSetChecksum());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetChecksum()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.checksum, other.checksum);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetLength()).compareTo(other.isSetLength());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLength()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.length, other.length);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetVerno()).compareTo(other.isSetVerno());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetVerno()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.verno, other.verno);
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
    StringBuilder sb = new StringBuilder("Fileinfo(");
    boolean first = true;

    sb.append("fileName:");
    if (this.fileName == null) {
      sb.append("null");
    } else {
      sb.append(this.fileName);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("filePath:");
    if (this.filePath == null) {
      sb.append("null");
    } else {
      sb.append(this.filePath);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("checksum:");
    sb.append(this.checksum);
    first = false;
    if (!first) sb.append(", ");
    sb.append("length:");
    sb.append(this.length);
    first = false;
    if (!first) sb.append(", ");
    sb.append("verno:");
    if (this.verno == null) {
      sb.append("null");
    } else {
      sb.append(this.verno);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (verno != null) {
      verno.validate();
    }
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

  private static class FileinfoStandardSchemeFactory implements SchemeFactory {
    public FileinfoStandardScheme getScheme() {
      return new FileinfoStandardScheme();
    }
  }

  private static class FileinfoStandardScheme extends StandardScheme<Fileinfo> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Fileinfo struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // FILE_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.fileName = iprot.readString();
              struct.setFileNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // FILE_PATH
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.filePath = iprot.readString();
              struct.setFilePathIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // CHECKSUM
            if (schemeField.type == org.apache.thrift.protocol.TType.BYTE) {
              struct.checksum = iprot.readByte();
              struct.setChecksumIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // LENGTH
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.length = iprot.readI64();
              struct.setLengthIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // VERNO
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.verno = new Verno();
              struct.verno.read(iprot);
              struct.setVernoIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, Fileinfo struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.fileName != null) {
        oprot.writeFieldBegin(FILE_NAME_FIELD_DESC);
        oprot.writeString(struct.fileName);
        oprot.writeFieldEnd();
      }
      if (struct.filePath != null) {
        oprot.writeFieldBegin(FILE_PATH_FIELD_DESC);
        oprot.writeString(struct.filePath);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(CHECKSUM_FIELD_DESC);
      oprot.writeByte(struct.checksum);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(LENGTH_FIELD_DESC);
      oprot.writeI64(struct.length);
      oprot.writeFieldEnd();
      if (struct.verno != null) {
        oprot.writeFieldBegin(VERNO_FIELD_DESC);
        struct.verno.write(oprot);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class FileinfoTupleSchemeFactory implements SchemeFactory {
    public FileinfoTupleScheme getScheme() {
      return new FileinfoTupleScheme();
    }
  }

  private static class FileinfoTupleScheme extends TupleScheme<Fileinfo> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Fileinfo struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetFileName()) {
        optionals.set(0);
      }
      if (struct.isSetFilePath()) {
        optionals.set(1);
      }
      if (struct.isSetChecksum()) {
        optionals.set(2);
      }
      if (struct.isSetLength()) {
        optionals.set(3);
      }
      if (struct.isSetVerno()) {
        optionals.set(4);
      }
      oprot.writeBitSet(optionals, 5);
      if (struct.isSetFileName()) {
        oprot.writeString(struct.fileName);
      }
      if (struct.isSetFilePath()) {
        oprot.writeString(struct.filePath);
      }
      if (struct.isSetChecksum()) {
        oprot.writeByte(struct.checksum);
      }
      if (struct.isSetLength()) {
        oprot.writeI64(struct.length);
      }
      if (struct.isSetVerno()) {
        struct.verno.write(oprot);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Fileinfo struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(5);
      if (incoming.get(0)) {
        struct.fileName = iprot.readString();
        struct.setFileNameIsSet(true);
      }
      if (incoming.get(1)) {
        struct.filePath = iprot.readString();
        struct.setFilePathIsSet(true);
      }
      if (incoming.get(2)) {
        struct.checksum = iprot.readByte();
        struct.setChecksumIsSet(true);
      }
      if (incoming.get(3)) {
        struct.length = iprot.readI64();
        struct.setLengthIsSet(true);
      }
      if (incoming.get(4)) {
        struct.verno = new Verno();
        struct.verno.read(iprot);
        struct.setVernoIsSet(true);
      }
    }
  }

}

