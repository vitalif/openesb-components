package it.imolinfo.jbi4corba.test.webservice.generator.complexintType;

/**
* it/imolinfo/jbi4corba/test/webservice/generator/complexintType/Echo5Holder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Test-IntType-Complex-multInterface.idl
* luned� 19 gennaio 2009 9.37.07 CET
*/

public final class Echo5Holder implements org.omg.CORBA.portable.Streamable
{
  public it.imolinfo.jbi4corba.test.webservice.generator.complexintType.Echo5 value = null;

  public Echo5Holder ()
  {
  }

  public Echo5Holder (it.imolinfo.jbi4corba.test.webservice.generator.complexintType.Echo5 initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = it.imolinfo.jbi4corba.test.webservice.generator.complexintType.Echo5Helper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    it.imolinfo.jbi4corba.test.webservice.generator.complexintType.Echo5Helper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return it.imolinfo.jbi4corba.test.webservice.generator.complexintType.Echo5Helper.type ();
  }

}
