package it.imolinfo.jbi4corba.test.testprovidercomplexmult;


/**
* it/imolinfo/jbi4corba/test/testprovidercomplexmult/EchoComplex2POA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from multipleInterface
* luned� 15 febbraio 2010 16.40.38 CET
*/

public abstract class EchoComplex2POA extends org.omg.PortableServer.Servant
 implements it.imolinfo.jbi4corba.test.testprovidercomplexmult.EchoComplex2Operations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("echo2", new java.lang.Integer (0));
    _methods.put ("echoValueType2", new java.lang.Integer (1));
    _methods.put ("echoValueBoxedTypePrimitive2", new java.lang.Integer (2));
    _methods.put ("echoValueBoxedTypeComplex2", new java.lang.Integer (3));
    _methods.put ("echoStruct2", new java.lang.Integer (4));
    _methods.put ("echoSequence2", new java.lang.Integer (5));
    _methods.put ("echoSequenceValueType2", new java.lang.Integer (6));
    _methods.put ("echoSequenceSeqEchoStruct2", new java.lang.Integer (7));
    _methods.put ("echoSequenceSeqMySequence2", new java.lang.Integer (8));
    _methods.put ("echoExceptionThrown2", new java.lang.Integer (9));
    _methods.put ("echoExceptionNotThrown2", new java.lang.Integer (10));
    _methods.put ("echoStructOfStruct2", new java.lang.Integer (11));
    _methods.put ("echoVTPrimi2", new java.lang.Integer (12));
    _methods.put ("echoVTPrimiSeq2", new java.lang.Integer (13));
    _methods.put ("echoValueTypeOfValueType2", new java.lang.Integer (14));
    _methods.put ("echoValueTypeOfStruct2", new java.lang.Integer (15));
    _methods.put ("echoStructOfValuetype2", new java.lang.Integer (16));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // it/imolinfo/jbi4corba/test/testprovidercomplexmult/EchoComplex2/echo2
       {
         String msg = in.read_string ();
         String $result = null;
         $result = this.echo2 (msg);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 1:  // it/imolinfo/jbi4corba/test/testprovidercomplexmult/EchoComplex2/echoValueType2
       {
         it.imolinfo.jbi4corba.test.testprovidercomplexmult.EchoVT e = it.imolinfo.jbi4corba.test.testprovidercomplexmult.EchoVTHelper.read (in);
         it.imolinfo.jbi4corba.test.testprovidercomplexmult.EchoVT $result = null;
         $result = this.echoValueType2 (e);
         out = $rh.createReply();
         it.imolinfo.jbi4corba.test.testprovidercomplexmult.EchoVTHelper.write (out, $result);
         break;
       }

       case 2:  // it/imolinfo/jbi4corba/test/testprovidercomplexmult/EchoComplex2/echoValueBoxedTypePrimitive2
       {
         it.imolinfo.jbi4corba.test.testprovidercomplexmult.MyLong e = it.imolinfo.jbi4corba.test.testprovidercomplexmult.MyLongHelper.read (in);
         it.imolinfo.jbi4corba.test.testprovidercomplexmult.MyLong $result = null;
         $result = this.echoValueBoxedTypePrimitive2 (e);
         out = $rh.createReply();
         it.imolinfo.jbi4corba.test.testprovidercomplexmult.MyLongHelper.write (out, $result);
         break;
       }

       case 3:  // it/imolinfo/jbi4corba/test/testprovidercomplexmult/EchoComplex2/echoValueBoxedTypeComplex2
       {
         it.imolinfo.jbi4corba.test.testprovidercomplexmult.MySequence e = it.imolinfo.jbi4corba.test.testprovidercomplexmult.MySequenceHelper.read (in);
         it.imolinfo.jbi4corba.test.testprovidercomplexmult.MySequence $result = null;
         $result = this.echoValueBoxedTypeComplex2 (e);
         out = $rh.createReply();
         it.imolinfo.jbi4corba.test.testprovidercomplexmult.MySequenceHelper.write (out, $result);
         break;
       }

       case 4:  // it/imolinfo/jbi4corba/test/testprovidercomplexmult/EchoComplex2/echoStruct2
       {
         it.imolinfo.jbi4corba.test.testprovidercomplexmult.EchoStruct es = it.imolinfo.jbi4corba.test.testprovidercomplexmult.EchoStructHelper.read (in);
         it.imolinfo.jbi4corba.test.testprovidercomplexmult.EchoStruct $result = null;
         $result = this.echoStruct2 (es);
         out = $rh.createReply();
         it.imolinfo.jbi4corba.test.testprovidercomplexmult.EchoStructHelper.write (out, $result);
         break;
       }

       case 5:  // it/imolinfo/jbi4corba/test/testprovidercomplexmult/EchoComplex2/echoSequence2
       {
         int es[] = it.imolinfo.jbi4corba.test.testprovidercomplexmult.SeqLongHelper.read (in);
         int $result[] = null;
         $result = this.echoSequence2 (es);
         out = $rh.createReply();
         it.imolinfo.jbi4corba.test.testprovidercomplexmult.SeqLongHelper.write (out, $result);
         break;
       }

       case 6:  // it/imolinfo/jbi4corba/test/testprovidercomplexmult/EchoComplex2/echoSequenceValueType2
       {
         it.imolinfo.jbi4corba.test.testprovidercomplexmult.MySequence es = it.imolinfo.jbi4corba.test.testprovidercomplexmult.MySequenceHelper.read (in);
         it.imolinfo.jbi4corba.test.testprovidercomplexmult.MySequence $result = null;
         $result = this.echoSequenceValueType2 (es);
         out = $rh.createReply();
         it.imolinfo.jbi4corba.test.testprovidercomplexmult.MySequenceHelper.write (out, $result);
         break;
       }

       case 7:  // it/imolinfo/jbi4corba/test/testprovidercomplexmult/EchoComplex2/echoSequenceSeqEchoStruct2
       {
         it.imolinfo.jbi4corba.test.testprovidercomplexmult.EchoStruct es[] = it.imolinfo.jbi4corba.test.testprovidercomplexmult.SeqEchoStructHelper.read (in);
         it.imolinfo.jbi4corba.test.testprovidercomplexmult.EchoStruct $result[] = null;
         $result = this.echoSequenceSeqEchoStruct2 (es);
         out = $rh.createReply();
         it.imolinfo.jbi4corba.test.testprovidercomplexmult.SeqEchoStructHelper.write (out, $result);
         break;
       }

       case 8:  // it/imolinfo/jbi4corba/test/testprovidercomplexmult/EchoComplex2/echoSequenceSeqMySequence2
       {
         it.imolinfo.jbi4corba.test.testprovidercomplexmult.MySequence es[] = it.imolinfo.jbi4corba.test.testprovidercomplexmult.SeqMySequenceHelper.read (in);
         it.imolinfo.jbi4corba.test.testprovidercomplexmult.MySequence $result[] = null;
         $result = this.echoSequenceSeqMySequence2 (es);
         out = $rh.createReply();
         it.imolinfo.jbi4corba.test.testprovidercomplexmult.SeqMySequenceHelper.write (out, $result);
         break;
       }

       case 9:  // it/imolinfo/jbi4corba/test/testprovidercomplexmult/EchoComplex2/echoExceptionThrown2
       {
         try {
           it.imolinfo.jbi4corba.test.testprovidercomplexmult.EchoStruct es = it.imolinfo.jbi4corba.test.testprovidercomplexmult.EchoStructHelper.read (in);
           it.imolinfo.jbi4corba.test.testprovidercomplexmult.EchoStruct $result = null;
           $result = this.echoExceptionThrown2 (es);
           out = $rh.createReply();
           it.imolinfo.jbi4corba.test.testprovidercomplexmult.EchoStructHelper.write (out, $result);
         } catch (it.imolinfo.jbi4corba.test.testprovidercomplexmult.EchoComplexException $ex) {
           out = $rh.createExceptionReply ();
           it.imolinfo.jbi4corba.test.testprovidercomplexmult.EchoComplexExceptionHelper.write (out, $ex);
         }
         break;
       }

       case 10:  // it/imolinfo/jbi4corba/test/testprovidercomplexmult/EchoComplex2/echoExceptionNotThrown2
       {
         try {
           it.imolinfo.jbi4corba.test.testprovidercomplexmult.EchoStruct es = it.imolinfo.jbi4corba.test.testprovidercomplexmult.EchoStructHelper.read (in);
           it.imolinfo.jbi4corba.test.testprovidercomplexmult.EchoStruct $result = null;
           $result = this.echoExceptionNotThrown2 (es);
           out = $rh.createReply();
           it.imolinfo.jbi4corba.test.testprovidercomplexmult.EchoStructHelper.write (out, $result);
         } catch (it.imolinfo.jbi4corba.test.testprovidercomplexmult.EchoComplexException $ex) {
           out = $rh.createExceptionReply ();
           it.imolinfo.jbi4corba.test.testprovidercomplexmult.EchoComplexExceptionHelper.write (out, $ex);
         }
         break;
       }


  // UNSUPPORTED : string echoAbstractValueType(in AFoo n);
       case 11:  // it/imolinfo/jbi4corba/test/testprovidercomplexmult/EchoComplex2/echoStructOfStruct2
       {
         it.imolinfo.jbi4corba.test.testprovidercomplexmult.StructOfStruct v = it.imolinfo.jbi4corba.test.testprovidercomplexmult.StructOfStructHelper.read (in);
         it.imolinfo.jbi4corba.test.testprovidercomplexmult.StructOfStruct $result = null;
         $result = this.echoStructOfStruct2 (v);
         out = $rh.createReply();
         it.imolinfo.jbi4corba.test.testprovidercomplexmult.StructOfStructHelper.write (out, $result);
         break;
       }

       case 12:  // it/imolinfo/jbi4corba/test/testprovidercomplexmult/EchoComplex2/echoVTPrimi2
       {
         it.imolinfo.jbi4corba.test.testprovidercomplexmult.VTPrimi v = it.imolinfo.jbi4corba.test.testprovidercomplexmult.VTPrimiHelper.read (in);
         it.imolinfo.jbi4corba.test.testprovidercomplexmult.VTPrimi $result = null;
         $result = this.echoVTPrimi2 (v);
         out = $rh.createReply();
         it.imolinfo.jbi4corba.test.testprovidercomplexmult.VTPrimiHelper.write (out, $result);
         break;
       }

       case 13:  // it/imolinfo/jbi4corba/test/testprovidercomplexmult/EchoComplex2/echoVTPrimiSeq2
       {
         it.imolinfo.jbi4corba.test.testprovidercomplexmult.VTPrimiSeq v = it.imolinfo.jbi4corba.test.testprovidercomplexmult.VTPrimiSeqHelper.read (in);
         it.imolinfo.jbi4corba.test.testprovidercomplexmult.VTPrimiSeq $result = null;
         $result = this.echoVTPrimiSeq2 (v);
         out = $rh.createReply();
         it.imolinfo.jbi4corba.test.testprovidercomplexmult.VTPrimiSeqHelper.write (out, $result);
         break;
       }

       case 14:  // it/imolinfo/jbi4corba/test/testprovidercomplexmult/EchoComplex2/echoValueTypeOfValueType2
       {
         it.imolinfo.jbi4corba.test.testprovidercomplexmult.ValueTypeOfValueType v = it.imolinfo.jbi4corba.test.testprovidercomplexmult.ValueTypeOfValueTypeHelper.read (in);
         it.imolinfo.jbi4corba.test.testprovidercomplexmult.ValueTypeOfValueType $result = null;
         $result = this.echoValueTypeOfValueType2 (v);
         out = $rh.createReply();
         it.imolinfo.jbi4corba.test.testprovidercomplexmult.ValueTypeOfValueTypeHelper.write (out, $result);
         break;
       }

       case 15:  // it/imolinfo/jbi4corba/test/testprovidercomplexmult/EchoComplex2/echoValueTypeOfStruct2
       {
         it.imolinfo.jbi4corba.test.testprovidercomplexmult.ValueTypeOfStruct v = it.imolinfo.jbi4corba.test.testprovidercomplexmult.ValueTypeOfStructHelper.read (in);
         it.imolinfo.jbi4corba.test.testprovidercomplexmult.ValueTypeOfStruct $result = null;
         $result = this.echoValueTypeOfStruct2 (v);
         out = $rh.createReply();
         it.imolinfo.jbi4corba.test.testprovidercomplexmult.ValueTypeOfStructHelper.write (out, $result);
         break;
       }

       case 16:  // it/imolinfo/jbi4corba/test/testprovidercomplexmult/EchoComplex2/echoStructOfValuetype2
       {
         it.imolinfo.jbi4corba.test.testprovidercomplexmult.StructOfValuetype v = it.imolinfo.jbi4corba.test.testprovidercomplexmult.StructOfValuetypeHelper.read (in);
         it.imolinfo.jbi4corba.test.testprovidercomplexmult.StructOfValuetype $result = null;
         $result = this.echoStructOfValuetype2 (v);
         out = $rh.createReply();
         it.imolinfo.jbi4corba.test.testprovidercomplexmult.StructOfValuetypeHelper.write (out, $result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:it/imolinfo/jbi4corba/test/testprovidercomplexmult/EchoComplex2:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public EchoComplex2 _this() 
  {
    return EchoComplex2Helper.narrow(
    super._this_object());
  }

  public EchoComplex2 _this(org.omg.CORBA.ORB orb) 
  {
    return EchoComplex2Helper.narrow(
    super._this_object(orb));
  }


} // class EchoComplex2POA
