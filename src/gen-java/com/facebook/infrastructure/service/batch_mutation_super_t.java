/**
 * Autogenerated by Thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package com.facebook.infrastructure.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TException;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TList;
import com.facebook.thrift.protocol.TMap;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import com.facebook.thrift.protocol.TType;

public class batch_mutation_super_t implements TBase, java.io.Serializable {
  public String table;
  public String key;
  public Map<String, List<superColumn_t>> cfmap;

  public final Isset __isset = new Isset();

  public static final class Isset implements java.io.Serializable {
    public boolean table = false;
    public boolean key = false;
    public boolean cfmap = false;
  }

  public batch_mutation_super_t() {
  }

  public batch_mutation_super_t(String table, String key,
      Map<String, List<superColumn_t>> cfmap) {
    this();
    this.table = table;
    this.__isset.table = true;
    this.key = key;
    this.__isset.key = true;
    this.cfmap = cfmap;
    this.__isset.cfmap = true;
  }

  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof batch_mutation_super_t)
      return this.equals((batch_mutation_super_t) that);
    return false;
  }

  public boolean equals(batch_mutation_super_t that) {
    if (that == null)
      return false;

    boolean this_present_table = true && (this.table != null);
    boolean that_present_table = true && (that.table != null);
    if (this_present_table || that_present_table) {
      if (!(this_present_table && that_present_table))
        return false;
      if (!this.table.equals(that.table))
        return false;
    }

    boolean this_present_key = true && (this.key != null);
    boolean that_present_key = true && (that.key != null);
    if (this_present_key || that_present_key) {
      if (!(this_present_key && that_present_key))
        return false;
      if (!this.key.equals(that.key))
        return false;
    }

    boolean this_present_cfmap = true && (this.cfmap != null);
    boolean that_present_cfmap = true && (that.cfmap != null);
    if (this_present_cfmap || that_present_cfmap) {
      if (!(this_present_cfmap && that_present_cfmap))
        return false;
      if (!this.cfmap.equals(that.cfmap))
        return false;
    }

    return true;
  }

  public int hashCode() {
    return 0;
  }

  public void read(TProtocol iprot) throws TException {
    TField field;
    iprot.readStructBegin();
    while (true) {
      field = iprot.readFieldBegin();
      if (field.type == TType.STOP) {
        break;
      }
      switch (field.id) {
      case 1:
        if (field.type == TType.STRING) {
          this.table = iprot.readString();
          this.__isset.table = true;
        } else {
          TProtocolUtil.skip(iprot, field.type);
        }
        break;
      case 2:
        if (field.type == TType.STRING) {
          this.key = iprot.readString();
          this.__isset.key = true;
        } else {
          TProtocolUtil.skip(iprot, field.type);
        }
        break;
      case 3:
        if (field.type == TType.MAP) {
          {
            TMap _map13 = iprot.readMapBegin();
            this.cfmap = new HashMap<String, List<superColumn_t>>(
                2 * _map13.size);
            for (int _i14 = 0; _i14 < _map13.size; ++_i14) {
              String _key15;
              List<superColumn_t> _val16;
              _key15 = iprot.readString();
              {
                TList _list17 = iprot.readListBegin();
                _val16 = new ArrayList<superColumn_t>(_list17.size);
                for (int _i18 = 0; _i18 < _list17.size; ++_i18) {
                  superColumn_t _elem19 = new superColumn_t();
                  _elem19 = new superColumn_t();
                  _elem19.read(iprot);
                  _val16.add(_elem19);
                }
                iprot.readListEnd();
              }
              this.cfmap.put(_key15, _val16);
            }
            iprot.readMapEnd();
          }
          this.__isset.cfmap = true;
        } else {
          TProtocolUtil.skip(iprot, field.type);
        }
        break;
      default:
        TProtocolUtil.skip(iprot, field.type);
        break;
      }
      iprot.readFieldEnd();
    }
    iprot.readStructEnd();
  }

  public void write(TProtocol oprot) throws TException {
    TStruct struct = new TStruct("batch_mutation_super_t");
    oprot.writeStructBegin(struct);
    TField field = new TField();
    if (this.table != null) {
      field.name = "table";
      field.type = TType.STRING;
      field.id = 1;
      oprot.writeFieldBegin(field);
      oprot.writeString(this.table);
      oprot.writeFieldEnd();
    }
    if (this.key != null) {
      field.name = "key";
      field.type = TType.STRING;
      field.id = 2;
      oprot.writeFieldBegin(field);
      oprot.writeString(this.key);
      oprot.writeFieldEnd();
    }
    if (this.cfmap != null) {
      field.name = "cfmap";
      field.type = TType.MAP;
      field.id = 3;
      oprot.writeFieldBegin(field);
      {
        oprot.writeMapBegin(new TMap(TType.STRING, TType.LIST, this.cfmap
            .size()));
        for (String _iter20 : this.cfmap.keySet()) {
          oprot.writeString(_iter20);
          {
            oprot.writeListBegin(new TList(TType.STRUCT, this.cfmap
                .get(_iter20).size()));
            for (superColumn_t _iter21 : this.cfmap.get(_iter20)) {
              _iter21.write(oprot);
            }
            oprot.writeListEnd();
          }
        }
        oprot.writeMapEnd();
      }
      oprot.writeFieldEnd();
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  public String toString() {
    StringBuilder sb = new StringBuilder("batch_mutation_super_t(");
    sb.append("table:");
    sb.append(this.table);
    sb.append(",key:");
    sb.append(this.key);
    sb.append(",cfmap:");
    sb.append(this.cfmap);
    sb.append(")");
    return sb.toString();
  }

}