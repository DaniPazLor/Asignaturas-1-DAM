package User;


/**
 * Cache' Java Class Generated for class User.Direccion on version Cache for Windows (x86-32) 2010.1.3 (Build 703.0_SU) Sun Jul 25 2010 16:14:54 EDT.<br>
 *
 * @see <a href = "http://PC:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=User.Direccion</A>
**/

public class Direccion extends com.intersys.classes.SerialObject implements java.io.Serializable {
    private static final long serialVersionUID = 3695;
    private static String CACHE_CLASS_NAME = "User.Direccion";
    /**
           <p>NB: DO NOT USE IN APPLICATION(!!!).
           <br>Use <code>User.Direccion.open</code> instead!</br></p>
           <p>
           Used to construct a Java object, corresponding to existing object
           in Cache database.
           </p>
           @see #_open(com.intersys.objects.Database, com.intersys.objects.Oid)
           @see #open(com.intersys.objects.Database, com.intersys.objects.Oid)
    */
    public Direccion (com.intersys.cache.CacheObject ref) throws com.intersys.objects.CacheException {
        super (ref);
    }
    public Direccion (com.intersys.objects.Database db, String initstr) throws com.intersys.objects.CacheException {
        super (((com.intersys.cache.SysDatabase)db).newCacheObject (CACHE_CLASS_NAME,initstr));
    }
    public static com.intersys.classes.RegisteredObject createClientObject (com.intersys.objects.Database db)throws com.intersys.objects.CacheException {
        com.intersys.cache.CacheObject cobj = (((com.intersys.cache.SysDatabase)db).newClientObject(CACHE_CLASS_NAME));
        return new Direccion (cobj);
    }
    public static com.intersys.classes.SerialObject open (com.intersys.objects.Database db, byte[] serialState) throws com.intersys.objects.CacheException {
         com.intersys.cache.CacheObject cobj = ((com.intersys.cache.SysDatabase)db).deserializeObject (CACHE_CLASS_NAME, serialState);
         return (com.intersys.classes.SerialObject) cobj.newJavaInstance();
    }
    /**
       Creates a new instance of object "User.Direccion" in Cache
       database and corresponding object of class
       <code>User.Direccion</code>.

       @param db <code>Database</code> object used for connection with
       Cache database.

       @throws com.intersys.objects.CacheException in case of error.

              @see #_open(com.intersys.objects.Database, com.intersys.objects.Oid)
              @see #open(com.intersys.objects.Database, com.intersys.objects.Oid)
     */
    public Direccion (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
        super (((com.intersys.cache.SysDatabase)db).newCacheObject (CACHE_CLASS_NAME));
    }
    /**
       Runs method <code> %OpenId </code> in Cache to open an object
       from Cache database and creates corresponding object of class
       <code>User.Direccion</code>.

       @return <code> RegisteredObject </code>, corresponding to opened
       object. This object may be of <code>User.Direccion</code> or of
      any of its subclasses. Cast to <code>User.Direccion</code> is
      guaranteed to pass without <code>ClassCastException</code> exception.

       @param db <code>Database</code> object used for connection with
       Cache database.

       @param id ID as specified in Cache represented as
      <code>Id</code>.

       @throws com.intersys.objects.CacheException in case of error.
      @see java.lang.ClassCastException
           @see #_open(com.intersys.objects.Database, com.intersys.objects.Oid)
           @see #open(com.intersys.objects.Database, com.intersys.objects.Oid)
           @see #Direccion
     */
    public static com.intersys.classes.RegisteredObject _open (com.intersys.objects.Database db, com.intersys.objects.Id id) throws com.intersys.objects.CacheException {
        return open(db, id);
    }
    /**
       Runs method <code> %OpenId </code> in Cache to open an object
       from Cache database and creates corresponding object of class
       <code>User.Direccion</code>.

       @return <code> RegisteredObject </code>, corresponding to opened
       object. This object may be of <code>User.Direccion</code> or of
      any of its subclasses. Cast to <code>User.Direccion</code> is
      guaranteed to pass without <code>ClassCastException</code> exception.

       @param db <code>Database</code> object used for connection with
       Cache database.

       @param id ID as specified in Cache represented as
      <code>Id</code>.

       @throws com.intersys.objects.CacheException in case of error.
      @see java.lang.ClassCastException
           @see #_open(com.intersys.objects.Database, com.intersys.objects.Oid)
           @see #open(com.intersys.objects.Database, com.intersys.objects.Oid)
           @see #Direccion
     */
    public static com.intersys.classes.RegisteredObject open (com.intersys.objects.Database db, com.intersys.objects.Id id) throws com.intersys.objects.CacheException {
        com.intersys.cache.CacheObject cobj = (((com.intersys.cache.SysDatabase)db).openCacheObject(CACHE_CLASS_NAME, id.toString()));
        return (com.intersys.classes.RegisteredObject)(cobj.newJavaInstance());
    }
    /**
       Runs method <code> %OpenId </code> in Cache to open an object
       from Cache database and creates corresponding object of class
       <code>User.Direccion</code>.

       @return <code> RegisteredObject </code>, corresponding to opened
       object. This object may be of <code>User.Direccion</code> or of
      any of its subclasses. Cast to <code>User.Direccion</code> is
      guaranteed to pass without <code>ClassCastException</code> exception.

       @param db <code>Database</code> object used for connection with
       Cache database.

       @param id ID as specified in Cache represented as
      <code>Id</code>.
      @param concurrency Concurrency level.  represented as
      <code>Concurrency</code>.

      Here are concurrency values, see Object Concurrency Options in your on-line Cache' documentation for more information.
      @see <a href = "http://PC:57772/csp/documatic/DocBook.UI.Page.cls?KEY=GOBJ_concurrency"> Object Concurrency Options.</A>

      <TABLE border="1"
      summary="Object Concurrency Options.">
      <CAPTION><EM>Object Concurrency Options</EM></CAPTION>
      <TR><TD>-1 </TD><TD>Default concurrency</TD></TR>
      <TR><TD>0 </TD><TD>No locking, no locks are used</TD></TR>
      <TR><TD>1 </TD><TD>Atomic</TD></TR>
      <TR><TD>2 </TD><TD>Shared</TD></TR>
      <TR><TD>3 </TD><TD>Shared/Retained</TD></TR>
      <TR><TD>4 </TD><TD>Exclusive</TD></TR>
      </TABLE>

       @throws com.intersys.objects.CacheException in case of error.
      @see java.lang.ClassCastException
           @see #_open(com.intersys.objects.Database, com.intersys.objects.Oid)
           @see #open(com.intersys.objects.Database, com.intersys.objects.Oid)
           @see #Direccion
     */
    public static com.intersys.classes.RegisteredObject _open (com.intersys.objects.Database db, com.intersys.objects.Id id, int concurrency) throws com.intersys.objects.CacheException {
        return open(db, id, concurrency);
    }
    /**
       Runs method <code> %OpenId </code> in Cache to open an object
       from Cache database and creates corresponding object of class
       <code>User.Direccion</code>.

       @return <code> RegisteredObject </code>, corresponding to opened
       object. This object may be of <code>User.Direccion</code> or of
      any of its subclasses. Cast to <code>User.Direccion</code> is
      guaranteed to pass without <code>ClassCastException</code> exception.

       @param db <code>Database</code> object used for connection with
       Cache database.

       @param id ID as specified in Cache represented as
      <code>Id</code>.
      @param concurrency Concurrency level.  represented as
      <code>Concurrency</code>.

      Here are concurrency values, see Object Concurrency Options in your on-line Cache' documentation for more information.
      @see <a href = "http://PC:57772/csp/documatic/DocBook.UI.Page.cls?KEY=GOBJ_concurrency"> Object Concurrency Options.</A>

      <TABLE border="1"
      summary="Object Concurrency Options.">
      <CAPTION><EM>Object Concurrency Options</EM></CAPTION>
      <TR><TD>-1 </TD><TD>Default concurrency</TD></TR>
      <TR><TD>0 </TD><TD>No locking, no locks are used</TD></TR>
      <TR><TD>1 </TD><TD>Atomic</TD></TR>
      <TR><TD>2 </TD><TD>Shared</TD></TR>
      <TR><TD>3 </TD><TD>Shared/Retained</TD></TR>
      <TR><TD>4 </TD><TD>Exclusive</TD></TR>
      </TABLE>

       @throws com.intersys.objects.CacheException in case of error.
      @see java.lang.ClassCastException
           @see #_open(com.intersys.objects.Database, com.intersys.objects.Oid)
           @see #open(com.intersys.objects.Database, com.intersys.objects.Oid)
           @see #Direccion
     */
    public static com.intersys.classes.RegisteredObject open (com.intersys.objects.Database db, com.intersys.objects.Id id, int concurrency) throws com.intersys.objects.CacheException {
        com.intersys.cache.CacheObject cobj = (((com.intersys.cache.SysDatabase)db).openCacheObject(CACHE_CLASS_NAME, id.toString(), concurrency));
        return (com.intersys.classes.RegisteredObject)(cobj.newJavaInstance());
    }
    /**
       Runs method <code> %Open </code> in Cache to open an object
       from Cache database and creates corresponding object of class
       <code>User.Direccion</code>.

       @return <code> RegisteredObject </code>, corresponding to opened
       object. This object may be of <code>User.Direccion</code> or of
      any of its subclasses. Cast to <code>User.Direccion</code> is
      guaranteed to pass without <code>ClassCastException</code> exception.

       @param db <code>Database</code> object used for connection with
       Cache database.
       @param oid Object ID as specified in Cache. represented as
      <code>Oid</code>.


       @throws com.intersys.objects.CacheException in case of error.
      @see java.lang.ClassCastException
           @see #_open(com.intersys.objects.Database, com.intersys.objects.Oid)
           @see #open(com.intersys.objects.Database, com.intersys.objects.Oid)
           @see #Direccion(com.intersys.objects.Database)
     */
    public static com.intersys.classes.RegisteredObject _open (com.intersys.objects.Database db, com.intersys.objects.Oid oid) throws com.intersys.objects.CacheException {
        return open(db, oid);
    }
    /**
       Runs method <code> %Open </code> in Cache to open an object
       from Cache database and creates corresponding object of class
       <code>User.Direccion</code>.

       @return <code> RegisteredObject </code>, corresponding to opened
       object. This object may be of <code>User.Direccion</code> or of
      any of its subclasses. Cast to <code>User.Direccion</code> is
      guaranteed to pass without <code>ClassCastException</code> exception.

       @param db <code>Database</code> object used for connection with
       Cache database.
       @param oid Object ID as specified in Cache. represented as
      <code>Oid</code>.


       @throws com.intersys.objects.CacheException in case of error.
      @see java.lang.ClassCastException
           @see #_open(com.intersys.objects.Database, com.intersys.objects.Oid)
           @see #open(com.intersys.objects.Database, com.intersys.objects.Oid)
           @see #Direccion(com.intersys.objects.Database)
     */
    public static com.intersys.classes.RegisteredObject open (com.intersys.objects.Database db, com.intersys.objects.Oid oid) throws com.intersys.objects.CacheException {
        com.intersys.cache.CacheObject cobj = (((com.intersys.cache.SysDatabase)db).openCacheObject(CACHE_CLASS_NAME, oid.getData()));
        return (com.intersys.classes.RegisteredObject)(cobj.newJavaInstance());
    }
    /**
       Runs method <code> %Open </code> in Cache to open an object
       from Cache database and creates corresponding object of class
       <code>User.Direccion</code>.

       @return <code> RegisteredObject </code>, corresponding to opened
       object. This object may be of <code>User.Direccion</code> or of
      any of its subclasses. Cast to <code>User.Direccion</code> is
      guaranteed to pass without <code>ClassCastException</code> exception.

       @param db <code>Database</code> object used for connection with
       Cache database.
       @param oid Object ID as specified in Cache. represented as
      <code>Oid</code>.
      @param concurrency Concurrency level.  represented as
      <code>Concurrency</code>.

      Here are concurrency values, see Object Concurrency Options in your on-line Cache' documentation for more information.
      @see <a href = "http://PC:57772/csp/documatic/DocBook.UI.Page.cls?KEY=GOBJ_concurrency"> Object Concurrency Options.</A>

      <TABLE border="1"
      summary="Object Concurrency Options.">
      <CAPTION><EM>Object Concurrency Options</EM></CAPTION>
      <TR><TD>-1 </TD><TD>Default concurrency</TD></TR>
      <TR><TD>0 </TD><TD>No locking, no locks are used</TD></TR>
      <TR><TD>1 </TD><TD>Atomic</TD></TR>
      <TR><TD>2 </TD><TD>Shared</TD></TR>
      <TR><TD>3 </TD><TD>Shared/Retained</TD></TR>
      <TR><TD>4 </TD><TD>Exclusive</TD></TR>
      </TABLE>

      @throws com.intersys.objects.CacheException in case of error.
      @see java.lang.ClassCastException
           @see #_open(com.intersys.objects.Database, com.intersys.objects.Oid)
           @see #open(com.intersys.objects.Database, com.intersys.objects.Oid)
           @see #Direccion(com.intersys.objects.Database)
     */
    public static com.intersys.classes.RegisteredObject _open (com.intersys.objects.Database db, com.intersys.objects.Oid oid, int concurrency) throws com.intersys.objects.CacheException {
        return open(db, oid, concurrency);
    }
    /**
       Runs method <code> %Open </code> in Cache to open an object
       from Cache database and creates corresponding object of class
       <code>User.Direccion</code>.

       @return <code> RegisteredObject </code>, corresponding to opened
       object. This object may be of <code>User.Direccion</code> or of
      any of its subclasses. Cast to <code>User.Direccion</code> is
      guaranteed to pass without <code>ClassCastException</code> exception.

       @param db <code>Database</code> object used for connection with
       Cache database.
       @param oid Object ID as specified in Cache. represented as
      <code>Oid</code>.
      @param concurrency Concurrency level.  represented as
      <code>Concurrency</code>.

      Here are concurrency values, see Object Concurrency Options in your on-line Cache' documentation for more information.
      @see <a href = "http://PC:57772/csp/documatic/DocBook.UI.Page.cls?KEY=GOBJ_concurrency"> Object Concurrency Options.</A>

      <TABLE border="1"
      summary="Object Concurrency Options.">
      <CAPTION><EM>Object Concurrency Options</EM></CAPTION>
      <TR><TD>-1 </TD><TD>Default concurrency</TD></TR>
      <TR><TD>0 </TD><TD>No locking, no locks are used</TD></TR>
      <TR><TD>1 </TD><TD>Atomic</TD></TR>
      <TR><TD>2 </TD><TD>Shared</TD></TR>
      <TR><TD>3 </TD><TD>Shared/Retained</TD></TR>
      <TR><TD>4 </TD><TD>Exclusive</TD></TR>
      </TABLE>

      @throws com.intersys.objects.CacheException in case of error.
      @see java.lang.ClassCastException
           @see #_open(com.intersys.objects.Database, com.intersys.objects.Oid)
           @see #open(com.intersys.objects.Database, com.intersys.objects.Oid)
           @see #Direccion(com.intersys.objects.Database)
     */
    public static com.intersys.classes.RegisteredObject open (com.intersys.objects.Database db, com.intersys.objects.Oid oid, int concurrency) throws com.intersys.objects.CacheException {
        com.intersys.cache.CacheObject cobj = (((com.intersys.cache.SysDatabase)db).openCacheObject(CACHE_CLASS_NAME, oid.getData(), concurrency));
        return (com.intersys.classes.RegisteredObject)(cobj.newJavaInstance());
    }
    /**
       Runs method <code> %Delete </code> in Cache to delete an object
       from Cache database.

       Deletes the stored version of the object with OID <var>oid</var> from the database.
       It does not remove any in-memory versions of the object that may be present.

       @param db <code>Database</code> object used for connection with
       Cache database.

       @param id ID as specified in Cache represented as
       <code>Id</code>.

       @throws com.intersys.objects.CacheException in case of error.
      @see java.lang.ClassCastException
           @see #_deleteId(com.intersys.objects.Database, com.intersys.objects.Id)
           @see #Direccion
     */
    public static void delete (com.intersys.objects.Database db, com.intersys.objects.Id id) throws com.intersys.objects.CacheException {
        ((com.intersys.cache.SysDatabase)db).deleteObject(CACHE_CLASS_NAME, id);
    }
    /**
       Runs method <code> %Delete </code> in Cache to delete an object
       from Cache database.

       Deletes the stored version of the object with OID <var>oid</var> from the database.
       It does not remove any in-memory versions of the object that may be present.

       @param db <code>Database</code> object used for connection with
       Cache database.

       @param id ID as specified in Cache represented as
       <code>Id</code>.
       @param concurrency Concurrency level.  represented as
       <code>Concurrency</code>.

      Here are concurrency values, see Object Concurrency Options in your on-line Cache' documentation for more information.
      @see <a href = "http://PC:57772/csp/documatic/DocBook.UI.Page.cls?KEY=GOBJ_concurrency"> Object Concurrency Options.</A>

      <TABLE border="1"
      summary="Object Concurrency Options.">
      <CAPTION><EM>Object Concurrency Options</EM></CAPTION>
      <TR><TD>-1 </TD><TD>Default concurrency</TD></TR>
      <TR><TD>0 </TD><TD>No locking, no locks are used</TD></TR>
      <TR><TD>1 </TD><TD>Atomic</TD></TR>
      <TR><TD>2 </TD><TD>Shared</TD></TR>
      <TR><TD>3 </TD><TD>Shared/Retained</TD></TR>
      <TR><TD>4 </TD><TD>Exclusive</TD></TR>
      </TABLE>


       @throws com.intersys.objects.CacheException in case of error.
      @see java.lang.ClassCastException
           @see #_deleteId(com.intersys.objects.Database, com.intersys.objects.Id)
           @see #Direccion
     */
    public static void delete (com.intersys.objects.Database db, com.intersys.objects.Id id, int concurrency) throws com.intersys.objects.CacheException {
        ((com.intersys.cache.SysDatabase)db).deleteObject(CACHE_CLASS_NAME, id, concurrency);
    }
    /**
       Runs method <code> %Delete </code> in Cache to delete an object
       from Cache database.

       Deletes the stored version of the object with OID <var>oid</var> from the database.
       It does not remove any in-memory versions of the object that may be present.

       @param db <code>Database</code> object used for connection with
       Cache database.

       @param id ID as specified in Cache represented as
       <code>Id</code>.

       @throws com.intersys.objects.CacheException in case of error.
      @see java.lang.ClassCastException
           @see #_deleteId(com.intersys.objects.Database, com.intersys.objects.Id)
           @see #Direccion
     */
    public static void _deleteId (com.intersys.objects.Database db, com.intersys.objects.Id id) throws com.intersys.objects.CacheException {
        delete(db, id);
    }
    /**
       Runs method <code> %Delete </code> in Cache to delete an object
       from Cache database.

       Deletes the stored version of the object with OID <var>oid</var> from the database.
       It does not remove any in-memory versions of the object that may be present.

       @param db <code>Database</code> object used for connection with
       Cache database.

       @param id ID as specified in Cache represented as
       <code>Id</code>.
       @param concurrency Concurrency level.  represented as
       <code>Concurrency</code>.

      Here are concurrency values, see Object Concurrency Options in your on-line Cache' documentation for more information.
      @see <a href = "http://PC:57772/csp/documatic/DocBook.UI.Page.cls?KEY=GOBJ_concurrency"> Object Concurrency Options.</A>

      <TABLE border="1"
      summary="Object Concurrency Options.">
      <CAPTION><EM>Object Concurrency Options</EM></CAPTION>
      <TR><TD>-1 </TD><TD>Default concurrency</TD></TR>
      <TR><TD>0 </TD><TD>No locking, no locks are used</TD></TR>
      <TR><TD>1 </TD><TD>Atomic</TD></TR>
      <TR><TD>2 </TD><TD>Shared</TD></TR>
      <TR><TD>3 </TD><TD>Shared/Retained</TD></TR>
      <TR><TD>4 </TD><TD>Exclusive</TD></TR>
      </TABLE>


       @throws com.intersys.objects.CacheException in case of error.
      @see java.lang.ClassCastException
           @see #_deleteId(com.intersys.objects.Database, com.intersys.objects.Id)
           @see #Direccion
     */
    public static void _deleteId (com.intersys.objects.Database db, com.intersys.objects.Id id, int concurrency) throws com.intersys.objects.CacheException {
        delete(db, id, concurrency);
    }
    /**
       Returns class name of the class User.Direccion as it is in
      Cache Database. Note, that this is a static method, so no
      object specific information can be returned. Use
      <code>getCacheClass().getName()</code> to get the class name
      for specific object.
       @return Cache class name as a <code>String</code>
      @see #getCacheClass()
      @see com.intersys.objects.reflect.CacheClass#getName()
     */
    public static String getCacheClassName( ) {
        return CACHE_CLASS_NAME;
    }

   /**
           Allows access metadata information about type of this object
           in Cache database. Also can be used for dynamic binding (accessing
           properties and calling methods without particular class known).

           @return <code>CacheClass</code> object for this object type.
   */
    public com.intersys.objects.reflect.CacheClass getCacheClass( ) throws com.intersys.objects.CacheException {
        return mInternal.getCacheClass();
    }

    /**
       Verifies that all fields from Cache class are exposed with
       accessor methods in Java class and that values for indexes in
       zObjVal are the same as in Cache. It does not return anything
       but it throws an exception in case of inconsistency.

       <p>But if there is any inconsistency in zObjVal indexes this is fatal and class can not work correctly and must be regenerated

       @param db Database used for connection. Note that if you are
       using multiple databases the class can be consistent with one
       and inconsistent with another.
       @throws com.intersys.objects.InvalidClassException if any inconsistency is found.
       @throws com.intersys.objects.CacheException if any error occurred during
       verification, e.g. communication error with Database.
       @see com.intersys.objects.InvalidPropertyException

     */
    public static void checkAllFieldsValid(com.intersys.objects.Database db ) throws com.intersys.objects.CacheException {
        checkAllFieldsValid(db, CACHE_CLASS_NAME, Direccion.class);
    }

    /**
       Verifies that all fields from Cache class are exposed with
       accessor methods in Java class and that values for indexes in
       zObjVal are the same as in Cache. It does not return anything
       but it throws an exception in case of inconsistency.

       <p>But if there is any inconsistency in zObjVal indexes this is fatal and class can not work correctly and must be regenerated

       @param db Database used for connection. Note that if you are
       using multiple databases the class can be consistent with one
       and inconsistent with another.
       @throws com.intersys.objects.InvalidClassException if any inconsistency is found.
       @throws com.intersys.objects.CacheException if any error occurred during
       verification, e.g. communication error with Database.
       @see com.intersys.objects.InvalidPropertyException

     */
    public static void checkAllMethods(com.intersys.objects.Database db ) throws com.intersys.objects.CacheException {
        checkAllMethods(db, CACHE_CLASS_NAME, Direccion.class);
    }
    private static int ii_codigopostal = 1;
    private static int jj_codigopostal = 0;
    private static int kk_codigopostal = 1;
    /**
       Verifies that indexes for property <code>codigopostal</code> in
       zObjVal are the same as in Cache. It does not return anything
       but it throws an exception in case of inconsistency.

       <p> Please note, that if there is any inconsistency in zObjVal
       indexes this is fatal and class can not work correctly and must
       be regenerated.

       @param db Database used for connection. Note that if you are
       using multiple databases the class can be consistent with one
       and inconsistent with another.
       @throws com.intersys.objects.InvalidClassException if any inconsistency is found.
       @throws com.intersys.objects.CacheException if any error occurred during
       verification, e.g. communication error with Database.
       @see #checkAllFieldsValid

     */
    public static void checkcodigopostalValid (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
        checkZobjValid(db, CACHE_CLASS_NAME, "codigopostal",ii_codigopostal, jj_codigopostal, kk_codigopostal);
    }
    /**
       Returns value of property <code>codigopostal</code>.
       <Description>
       @return current value of <code>codigopostal</code> represented as
       <code>java.lang.String</code>

       @throws com.intersys.objects.CacheException if any error occurred during value retrieval.
       @see <a href = "http://PC:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=User.Direccion#codigopostal"> codigopostal</A>
    */
    public java.lang.String getcodigopostal()  throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder dh = mInternal.getProperty(ii_codigopostal,
                                                jj_codigopostal,
                                                com.intersys.objects.Database.RET_PRIM,
                                                "codigopostal");
       return dh.getString();
    }

    /**
       Sets new value for <code>codigopostal</code>.
       <Description>
       @param value new value to be set represented as
       <code>java.lang.String</code>.
       @throws com.intersys.objects.CacheException if any error occurred during value setting.
       @see <a href = "http://PC:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=User.Direccion#codigopostal"> codigopostal</A>
    */
    public void setcodigopostal(java.lang.String value)  throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder dh = new com.intersys.cache.Dataholder (value);
        mInternal.setProperty(ii_codigopostal, jj_codigopostal,kk_codigopostal, com.intersys.objects.Database.RET_PRIM, "codigopostal", dh);
        return;
    }

    private static int ii_dirinterior = 4;
    private static int jj_dirinterior = 0;
    private static int kk_dirinterior = 4;
    /**
       Verifies that indexes for property <code>dirinterior</code> in
       zObjVal are the same as in Cache. It does not return anything
       but it throws an exception in case of inconsistency.

       <p> Please note, that if there is any inconsistency in zObjVal
       indexes this is fatal and class can not work correctly and must
       be regenerated.

       @param db Database used for connection. Note that if you are
       using multiple databases the class can be consistent with one
       and inconsistent with another.
       @throws com.intersys.objects.InvalidClassException if any inconsistency is found.
       @throws com.intersys.objects.CacheException if any error occurred during
       verification, e.g. communication error with Database.
       @see #checkAllFieldsValid

     */
    public static void checkdirinteriorValid (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
        checkZobjValid(db, CACHE_CLASS_NAME, "dirinterior",ii_dirinterior, jj_dirinterior, kk_dirinterior);
    }
    /**
       Returns value of property <code>dirinterior</code>.
       <Description>
       @return current value of <code>dirinterior</code> represented as
       <code>java.lang.String</code>

       @throws com.intersys.objects.CacheException if any error occurred during value retrieval.
       @see <a href = "http://PC:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=User.Direccion#dirinterior"> dirinterior</A>
    */
    public java.lang.String getdirinterior()  throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder dh = mInternal.getProperty(ii_dirinterior,
                                                jj_dirinterior,
                                                com.intersys.objects.Database.RET_PRIM,
                                                "dirinterior");
       return dh.getString();
    }

    /**
       Sets new value for <code>dirinterior</code>.
       <Description>
       @param value new value to be set represented as
       <code>java.lang.String</code>.
       @throws com.intersys.objects.CacheException if any error occurred during value setting.
       @see <a href = "http://PC:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=User.Direccion#dirinterior"> dirinterior</A>
    */
    public void setdirinterior(java.lang.String value)  throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder dh = new com.intersys.cache.Dataholder (value);
        mInternal.setProperty(ii_dirinterior, jj_dirinterior,kk_dirinterior, com.intersys.objects.Database.RET_PRIM, "dirinterior", dh);
        return;
    }

    private static int ii_localidad = 6;
    private static int jj_localidad = 0;
    private static int kk_localidad = 6;
    /**
       Verifies that indexes for property <code>localidad</code> in
       zObjVal are the same as in Cache. It does not return anything
       but it throws an exception in case of inconsistency.

       <p> Please note, that if there is any inconsistency in zObjVal
       indexes this is fatal and class can not work correctly and must
       be regenerated.

       @param db Database used for connection. Note that if you are
       using multiple databases the class can be consistent with one
       and inconsistent with another.
       @throws com.intersys.objects.InvalidClassException if any inconsistency is found.
       @throws com.intersys.objects.CacheException if any error occurred during
       verification, e.g. communication error with Database.
       @see #checkAllFieldsValid

     */
    public static void checklocalidadValid (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
        checkZobjValid(db, CACHE_CLASS_NAME, "localidad",ii_localidad, jj_localidad, kk_localidad);
    }
    /**
       Returns value of property <code>localidad</code>.
       <Description>
       @return current value of <code>localidad</code> represented as
       <code>java.lang.String</code>

       @throws com.intersys.objects.CacheException if any error occurred during value retrieval.
       @see <a href = "http://PC:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=User.Direccion#localidad"> localidad</A>
    */
    public java.lang.String getlocalidad()  throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder dh = mInternal.getProperty(ii_localidad,
                                                jj_localidad,
                                                com.intersys.objects.Database.RET_PRIM,
                                                "localidad");
       return dh.getString();
    }

    /**
       Sets new value for <code>localidad</code>.
       <Description>
       @param value new value to be set represented as
       <code>java.lang.String</code>.
       @throws com.intersys.objects.CacheException if any error occurred during value setting.
       @see <a href = "http://PC:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=User.Direccion#localidad"> localidad</A>
    */
    public void setlocalidad(java.lang.String value)  throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder dh = new com.intersys.cache.Dataholder (value);
        mInternal.setProperty(ii_localidad, jj_localidad,kk_localidad, com.intersys.objects.Database.RET_PRIM, "localidad", dh);
        return;
    }

    private static int ii_nombrevia = 5;
    private static int jj_nombrevia = 0;
    private static int kk_nombrevia = 5;
    /**
       Verifies that indexes for property <code>nombrevia</code> in
       zObjVal are the same as in Cache. It does not return anything
       but it throws an exception in case of inconsistency.

       <p> Please note, that if there is any inconsistency in zObjVal
       indexes this is fatal and class can not work correctly and must
       be regenerated.

       @param db Database used for connection. Note that if you are
       using multiple databases the class can be consistent with one
       and inconsistent with another.
       @throws com.intersys.objects.InvalidClassException if any inconsistency is found.
       @throws com.intersys.objects.CacheException if any error occurred during
       verification, e.g. communication error with Database.
       @see #checkAllFieldsValid

     */
    public static void checknombreviaValid (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
        checkZobjValid(db, CACHE_CLASS_NAME, "nombrevia",ii_nombrevia, jj_nombrevia, kk_nombrevia);
    }
    /**
       Returns value of property <code>nombrevia</code>.
       <Description>
       @return current value of <code>nombrevia</code> represented as
       <code>java.lang.String</code>

       @throws com.intersys.objects.CacheException if any error occurred during value retrieval.
       @see <a href = "http://PC:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=User.Direccion#nombrevia"> nombrevia</A>
    */
    public java.lang.String getnombrevia()  throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder dh = mInternal.getProperty(ii_nombrevia,
                                                jj_nombrevia,
                                                com.intersys.objects.Database.RET_PRIM,
                                                "nombrevia");
       return dh.getString();
    }

    /**
       Sets new value for <code>nombrevia</code>.
       <Description>
       @param value new value to be set represented as
       <code>java.lang.String</code>.
       @throws com.intersys.objects.CacheException if any error occurred during value setting.
       @see <a href = "http://PC:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=User.Direccion#nombrevia"> nombrevia</A>
    */
    public void setnombrevia(java.lang.String value)  throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder dh = new com.intersys.cache.Dataholder (value);
        mInternal.setProperty(ii_nombrevia, jj_nombrevia,kk_nombrevia, com.intersys.objects.Database.RET_PRIM, "nombrevia", dh);
        return;
    }

    private static int ii_numero = 9;
    private static int jj_numero = 0;
    private static int kk_numero = 9;
    /**
       Verifies that indexes for property <code>numero</code> in
       zObjVal are the same as in Cache. It does not return anything
       but it throws an exception in case of inconsistency.

       <p> Please note, that if there is any inconsistency in zObjVal
       indexes this is fatal and class can not work correctly and must
       be regenerated.

       @param db Database used for connection. Note that if you are
       using multiple databases the class can be consistent with one
       and inconsistent with another.
       @throws com.intersys.objects.InvalidClassException if any inconsistency is found.
       @throws com.intersys.objects.CacheException if any error occurred during
       verification, e.g. communication error with Database.
       @see #checkAllFieldsValid

     */
    public static void checknumeroValid (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
        checkZobjValid(db, CACHE_CLASS_NAME, "numero",ii_numero, jj_numero, kk_numero);
    }
    /**
       Returns value of property <code>numero</code>.
       <Description>
       @return current value of <code>numero</code> represented as
       <code>java.lang.Integer</code>

       @throws com.intersys.objects.CacheException if any error occurred during value retrieval.
       @see <a href = "http://PC:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=User.Direccion#numero"> numero</A>
    */
    public java.lang.Integer getnumero()  throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder dh = mInternal.getProperty(ii_numero,
                                                jj_numero,
                                                com.intersys.objects.Database.RET_PRIM,
                                                "numero");
       return dh.getInteger();
    }

    /**
       Sets new value for <code>numero</code>.
       <Description>
       @param value new value to be set represented as
       <code>java.lang.Integer</code>.
       @throws com.intersys.objects.CacheException if any error occurred during value setting.
       @see <a href = "http://PC:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=User.Direccion#numero"> numero</A>
    */
    public void setnumero(java.lang.Integer value)  throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder dh = new com.intersys.cache.Dataholder (value);
        mInternal.setProperty(ii_numero, jj_numero,kk_numero, com.intersys.objects.Database.RET_PRIM, "numero", dh);
        return;
    }

    private static int ii_pais = 2;
    private static int jj_pais = 0;
    private static int kk_pais = 2;
    /**
       Verifies that indexes for property <code>pais</code> in
       zObjVal are the same as in Cache. It does not return anything
       but it throws an exception in case of inconsistency.

       <p> Please note, that if there is any inconsistency in zObjVal
       indexes this is fatal and class can not work correctly and must
       be regenerated.

       @param db Database used for connection. Note that if you are
       using multiple databases the class can be consistent with one
       and inconsistent with another.
       @throws com.intersys.objects.InvalidClassException if any inconsistency is found.
       @throws com.intersys.objects.CacheException if any error occurred during
       verification, e.g. communication error with Database.
       @see #checkAllFieldsValid

     */
    public static void checkpaisValid (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
        checkZobjValid(db, CACHE_CLASS_NAME, "pais",ii_pais, jj_pais, kk_pais);
    }
    /**
       Returns value of property <code>pais</code>.
       <Description>
       @return current value of <code>pais</code> represented as
       <code>java.lang.String</code>

       @throws com.intersys.objects.CacheException if any error occurred during value retrieval.
       @see <a href = "http://PC:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=User.Direccion#pais"> pais</A>
    */
    public java.lang.String getpais()  throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder dh = mInternal.getProperty(ii_pais,
                                                jj_pais,
                                                com.intersys.objects.Database.RET_PRIM,
                                                "pais");
       return dh.getString();
    }

    /**
       Sets new value for <code>pais</code>.
       <Description>
       @param value new value to be set represented as
       <code>java.lang.String</code>.
       @throws com.intersys.objects.CacheException if any error occurred during value setting.
       @see <a href = "http://PC:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=User.Direccion#pais"> pais</A>
    */
    public void setpais(java.lang.String value)  throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder dh = new com.intersys.cache.Dataholder (value);
        mInternal.setProperty(ii_pais, jj_pais,kk_pais, com.intersys.objects.Database.RET_PRIM, "pais", dh);
        return;
    }

    private static int ii_provincia = 3;
    private static int jj_provincia = 0;
    private static int kk_provincia = 3;
    /**
       Verifies that indexes for property <code>provincia</code> in
       zObjVal are the same as in Cache. It does not return anything
       but it throws an exception in case of inconsistency.

       <p> Please note, that if there is any inconsistency in zObjVal
       indexes this is fatal and class can not work correctly and must
       be regenerated.

       @param db Database used for connection. Note that if you are
       using multiple databases the class can be consistent with one
       and inconsistent with another.
       @throws com.intersys.objects.InvalidClassException if any inconsistency is found.
       @throws com.intersys.objects.CacheException if any error occurred during
       verification, e.g. communication error with Database.
       @see #checkAllFieldsValid

     */
    public static void checkprovinciaValid (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
        checkZobjValid(db, CACHE_CLASS_NAME, "provincia",ii_provincia, jj_provincia, kk_provincia);
    }
    /**
       Returns value of property <code>provincia</code>.
       <Description>
       @return current value of <code>provincia</code> represented as
       <code>java.lang.String</code>

       @throws com.intersys.objects.CacheException if any error occurred during value retrieval.
       @see <a href = "http://PC:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=User.Direccion#provincia"> provincia</A>
    */
    public java.lang.String getprovincia()  throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder dh = mInternal.getProperty(ii_provincia,
                                                jj_provincia,
                                                com.intersys.objects.Database.RET_PRIM,
                                                "provincia");
       return dh.getString();
    }

    /**
       Sets new value for <code>provincia</code>.
       <Description>
       @param value new value to be set represented as
       <code>java.lang.String</code>.
       @throws com.intersys.objects.CacheException if any error occurred during value setting.
       @see <a href = "http://PC:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=User.Direccion#provincia"> provincia</A>
    */
    public void setprovincia(java.lang.String value)  throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder dh = new com.intersys.cache.Dataholder (value);
        mInternal.setProperty(ii_provincia, jj_provincia,kk_provincia, com.intersys.objects.Database.RET_PRIM, "provincia", dh);
        return;
    }

    private static int ii_region = 7;
    private static int jj_region = 0;
    private static int kk_region = 7;
    /**
       Verifies that indexes for property <code>region</code> in
       zObjVal are the same as in Cache. It does not return anything
       but it throws an exception in case of inconsistency.

       <p> Please note, that if there is any inconsistency in zObjVal
       indexes this is fatal and class can not work correctly and must
       be regenerated.

       @param db Database used for connection. Note that if you are
       using multiple databases the class can be consistent with one
       and inconsistent with another.
       @throws com.intersys.objects.InvalidClassException if any inconsistency is found.
       @throws com.intersys.objects.CacheException if any error occurred during
       verification, e.g. communication error with Database.
       @see #checkAllFieldsValid

     */
    public static void checkregionValid (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
        checkZobjValid(db, CACHE_CLASS_NAME, "region",ii_region, jj_region, kk_region);
    }
    /**
       Returns value of property <code>region</code>.
       <Description>
       @return current value of <code>region</code> represented as
       <code>java.lang.String</code>

       @throws com.intersys.objects.CacheException if any error occurred during value retrieval.
       @see <a href = "http://PC:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=User.Direccion#region"> region</A>
    */
    public java.lang.String getregion()  throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder dh = mInternal.getProperty(ii_region,
                                                jj_region,
                                                com.intersys.objects.Database.RET_PRIM,
                                                "region");
       return dh.getString();
    }

    /**
       Sets new value for <code>region</code>.
       <Description>
       @param value new value to be set represented as
       <code>java.lang.String</code>.
       @throws com.intersys.objects.CacheException if any error occurred during value setting.
       @see <a href = "http://PC:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=User.Direccion#region"> region</A>
    */
    public void setregion(java.lang.String value)  throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder dh = new com.intersys.cache.Dataholder (value);
        mInternal.setProperty(ii_region, jj_region,kk_region, com.intersys.objects.Database.RET_PRIM, "region", dh);
        return;
    }

    private static int ii_tipovia = 10;
    private static int jj_tipovia = 0;
    private static int kk_tipovia = 10;
    /**
       Verifies that indexes for property <code>tipovia</code> in
       zObjVal are the same as in Cache. It does not return anything
       but it throws an exception in case of inconsistency.

       <p> Please note, that if there is any inconsistency in zObjVal
       indexes this is fatal and class can not work correctly and must
       be regenerated.

       @param db Database used for connection. Note that if you are
       using multiple databases the class can be consistent with one
       and inconsistent with another.
       @throws com.intersys.objects.InvalidClassException if any inconsistency is found.
       @throws com.intersys.objects.CacheException if any error occurred during
       verification, e.g. communication error with Database.
       @see #checkAllFieldsValid

     */
    public static void checktipoviaValid (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
        checkZobjValid(db, CACHE_CLASS_NAME, "tipovia",ii_tipovia, jj_tipovia, kk_tipovia);
    }
    /**
       Returns value of property <code>tipovia</code>.
       <Description>
       @return current value of <code>tipovia</code> represented as
       <code>java.lang.String</code>

       @throws com.intersys.objects.CacheException if any error occurred during value retrieval.
       @see <a href = "http://PC:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=User.Direccion#tipovia"> tipovia</A>
    */
    public java.lang.String gettipovia()  throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder dh = mInternal.getProperty(ii_tipovia,
                                                jj_tipovia,
                                                com.intersys.objects.Database.RET_PRIM,
                                                "tipovia");
       return dh.getString();
    }

    /**
       Sets new value for <code>tipovia</code>.
       <Description>
       @param value new value to be set represented as
       <code>java.lang.String</code>.
       @throws com.intersys.objects.CacheException if any error occurred during value setting.
       @see <a href = "http://PC:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=User.Direccion#tipovia"> tipovia</A>
    */
    public void settipovia(java.lang.String value)  throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder dh = new com.intersys.cache.Dataholder (value);
        mInternal.setProperty(ii_tipovia, jj_tipovia,kk_tipovia, com.intersys.objects.Database.RET_PRIM, "tipovia", dh);
        return;
    }

    /**
     <p>Runs method %ClassName in Cache.</p>
     <p>Description: Returns the object's class name. The <var>fullname</var> determines how the
class name is represented. If it is 1 then it returns the full class name
including any package qualifier. If it is 0 (the default) then it returns the
name of the class without the package, this is mainly for backward compatibility
with the pre-package behaviour of %ClassName.</p>
     @param db represented as com.intersys.objects.Database
     @param fullname represented as java.lang.Boolean
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://PC:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=User.Direccion#%ClassName"> Method %ClassName</A>
    */
    public static java.lang.String sys_ClassName (com.intersys.objects.Database db, java.lang.Boolean fullname) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(fullname);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"%ClassName",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method %Delete in Cache.</p>
     <p>Description: Deletes streams referenced by this object and calls %Delete on any embedded objects

Refer to <LINK href=/AboutConcurrency.html>About Concurrency</LINK> for more details 
on the optional <var>concurrency</var> argument.

<p>Returns a <CLASS>%Status</CLASS> value indicating success or failure.
</p>
     @param db represented as com.intersys.objects.Database
     default argument oid set to ""
     default argument concurrency set to -1
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see #sys_Delete(com.intersys.objects.Database,com.intersys.objects.Oid,java.lang.Integer)
     @see <a href = "http://PC:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=User.Direccion#%Delete"> Method %Delete</A>
    */
    public static void sys_Delete (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[0];
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"%Delete",args,com.intersys.objects.Database.RET_PRIM);
        db.parseStatus(res);
        return;
    }
    /**
     <p>Runs method %Delete in Cache.</p>
     <p>Description: Deletes streams referenced by this object and calls %Delete on any embedded objects

Refer to <LINK href=/AboutConcurrency.html>About Concurrency</LINK> for more details 
on the optional <var>concurrency</var> argument.

<p>Returns a <CLASS>%Status</CLASS> value indicating success or failure.
</p>
     @param db represented as com.intersys.objects.Database
     @param oid represented as com.intersys.objects.Oid
     default argument concurrency set to -1
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see #sys_Delete(com.intersys.objects.Database,com.intersys.objects.Oid,java.lang.Integer)
     @see <a href = "http://PC:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=User.Direccion#%Delete"> Method %Delete</A>
    */
    public static void sys_Delete (com.intersys.objects.Database db, com.intersys.objects.Oid oid) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(oid);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"%Delete",args,com.intersys.objects.Database.RET_PRIM);
        db.parseStatus(res);
        return;
    }
    /**
     <p>Runs method %Delete in Cache.</p>
     <p>Description: Deletes streams referenced by this object and calls %Delete on any embedded objects

Refer to <LINK href=/AboutConcurrency.html>About Concurrency</LINK> for more details 
on the optional <var>concurrency</var> argument.

<p>Returns a <CLASS>%Status</CLASS> value indicating success or failure.
</p>
     @param db represented as com.intersys.objects.Database
     @param oid represented as com.intersys.objects.Oid
     @param concurrency represented as java.lang.Integer
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://PC:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=User.Direccion#%Delete"> Method %Delete</A>
    */
    public static void sys_Delete (com.intersys.objects.Database db, com.intersys.objects.Oid oid, java.lang.Integer concurrency) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[2];
        args[0] = new com.intersys.cache.Dataholder(oid);
        args[1] = new com.intersys.cache.Dataholder(concurrency);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"%Delete",args,com.intersys.objects.Database.RET_PRIM);
        db.parseStatus(res);
        return;
    }
    /**
     <p>Runs method %DeleteId in Cache.</p>
     <p>Description: Deletes the stored version of the object with ID <var>id</var> from the database. 

<p><METHOD>%DeleteId</METHOD> is identical in operation to the <METHOD>%Delete</METHOD> method except 
that it uses and Id value instead of an OID value to find an object.

Refer to <LINK href=/AboutConcurrency.html>About Concurrency</LINK> for more details 
on the optional <var>concurrency</var> argument.</p>
     @param db represented as com.intersys.objects.Database
     @param id represented as java.lang.String
     default argument concurrency set to -1
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see #sys_DeleteId(com.intersys.objects.Database,java.lang.String,java.lang.Integer)
     @see <a href = "http://PC:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=User.Direccion#%DeleteId"> Method %DeleteId</A>
    */
    public static void sys_DeleteId (com.intersys.objects.Database db, java.lang.String id) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(id);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"%DeleteId",args,com.intersys.objects.Database.RET_PRIM);
        db.parseStatus(res);
        return;
    }
    /**
     <p>Runs method %DeleteId in Cache.</p>
     <p>Description: Deletes the stored version of the object with ID <var>id</var> from the database. 

<p><METHOD>%DeleteId</METHOD> is identical in operation to the <METHOD>%Delete</METHOD> method except 
that it uses and Id value instead of an OID value to find an object.

Refer to <LINK href=/AboutConcurrency.html>About Concurrency</LINK> for more details 
on the optional <var>concurrency</var> argument.</p>
     @param db represented as com.intersys.objects.Database
     @param id represented as java.lang.String
     @param concurrency represented as java.lang.Integer
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://PC:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=User.Direccion#%DeleteId"> Method %DeleteId</A>
    */
    public static void sys_DeleteId (com.intersys.objects.Database db, java.lang.String id, java.lang.Integer concurrency) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[2];
        args[0] = new com.intersys.cache.Dataholder(id);
        args[1] = new com.intersys.cache.Dataholder(concurrency);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"%DeleteId",args,com.intersys.objects.Database.RET_PRIM);
        db.parseStatus(res);
        return;
    }
    /**
     <p>Runs method %IsA in Cache.</p>
     <p>Description: Returns true (1) if instances of this class are also instances of the isclass parameter.
That is 'isclass' is a primary superclass of this object.</p>
     @param db represented as com.intersys.objects.Database
     @param isclass represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://PC:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=User.Direccion#%IsA"> Method %IsA</A>
    */
    public static java.lang.Integer sys_IsA (com.intersys.objects.Database db, java.lang.String isclass) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(isclass);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"%IsA",args,com.intersys.objects.Database.RET_PRIM);
        return res.getInteger();
    }
    /**
     <p>Runs method LogicalToOdbc in Cache.</p>
     @param db represented as com.intersys.objects.Database
     default argument val set to ""
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see #LogicalToOdbc(com.intersys.objects.Database,java.lang.String)
     @see <a href = "http://PC:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=User.Direccion#LogicalToOdbc"> Method LogicalToOdbc</A>
    */
    public static java.lang.String LogicalToOdbc (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[0];
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"LogicalToOdbc",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method LogicalToOdbc in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param val represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://PC:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=User.Direccion#LogicalToOdbc"> Method LogicalToOdbc</A>
    */
    public static java.lang.String LogicalToOdbc (com.intersys.objects.Database db, java.lang.String val) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(val);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"LogicalToOdbc",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method OdbcToLogical in Cache.</p>
     @param db represented as com.intersys.objects.Database
     default argument val set to ""
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see #OdbcToLogical(com.intersys.objects.Database,java.lang.String)
     @see <a href = "http://PC:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=User.Direccion#OdbcToLogical"> Method OdbcToLogical</A>
    */
    public static java.lang.String OdbcToLogical (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[0];
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"OdbcToLogical",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method OdbcToLogical in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param val represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://PC:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=User.Direccion#OdbcToLogical"> Method OdbcToLogical</A>
    */
    public static java.lang.String OdbcToLogical (com.intersys.objects.Database db, java.lang.String val) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(val);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"OdbcToLogical",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method codigopostalDisplayToLogical in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param _val represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://PC:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=User.Direccion#codigopostalDisplayToLogical"> Method codigopostalDisplayToLogical</A>
    */
    public static java.lang.String codigopostalDisplayToLogical (com.intersys.objects.Database db, java.lang.String _val) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(_val);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"codigopostalDisplayToLogical",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method codigopostalIsValid in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param _val represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://PC:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=User.Direccion#codigopostalIsValid"> Method codigopostalIsValid</A>
    */
    public static void codigopostalIsValid (com.intersys.objects.Database db, java.lang.String _val) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(_val);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"codigopostalIsValid",args,com.intersys.objects.Database.RET_PRIM);
        db.parseStatus(res);
        return;
    }
    /**
     <p>Runs method codigopostalLogicalToDisplay in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param _val represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://PC:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=User.Direccion#codigopostalLogicalToDisplay"> Method codigopostalLogicalToDisplay</A>
    */
    public static java.lang.String codigopostalLogicalToDisplay (com.intersys.objects.Database db, java.lang.String _val) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(_val);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"codigopostalLogicalToDisplay",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method dirinteriorDisplayToLogical in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param _val represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://PC:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=User.Direccion#dirinteriorDisplayToLogical"> Method dirinteriorDisplayToLogical</A>
    */
    public static java.lang.String dirinteriorDisplayToLogical (com.intersys.objects.Database db, java.lang.String _val) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(_val);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"dirinteriorDisplayToLogical",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method dirinteriorIsValid in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param _val represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://PC:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=User.Direccion#dirinteriorIsValid"> Method dirinteriorIsValid</A>
    */
    public static void dirinteriorIsValid (com.intersys.objects.Database db, java.lang.String _val) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(_val);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"dirinteriorIsValid",args,com.intersys.objects.Database.RET_PRIM);
        db.parseStatus(res);
        return;
    }
    /**
     <p>Runs method dirinteriorLogicalToDisplay in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param _val represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://PC:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=User.Direccion#dirinteriorLogicalToDisplay"> Method dirinteriorLogicalToDisplay</A>
    */
    public static java.lang.String dirinteriorLogicalToDisplay (com.intersys.objects.Database db, java.lang.String _val) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(_val);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"dirinteriorLogicalToDisplay",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method localidadDisplayToLogical in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param _val represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://PC:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=User.Direccion#localidadDisplayToLogical"> Method localidadDisplayToLogical</A>
    */
    public static java.lang.String localidadDisplayToLogical (com.intersys.objects.Database db, java.lang.String _val) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(_val);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"localidadDisplayToLogical",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method localidadIsValid in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param _val represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://PC:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=User.Direccion#localidadIsValid"> Method localidadIsValid</A>
    */
    public static void localidadIsValid (com.intersys.objects.Database db, java.lang.String _val) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(_val);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"localidadIsValid",args,com.intersys.objects.Database.RET_PRIM);
        db.parseStatus(res);
        return;
    }
    /**
     <p>Runs method localidadLogicalToDisplay in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param _val represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://PC:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=User.Direccion#localidadLogicalToDisplay"> Method localidadLogicalToDisplay</A>
    */
    public static java.lang.String localidadLogicalToDisplay (com.intersys.objects.Database db, java.lang.String _val) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(_val);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"localidadLogicalToDisplay",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method nombreviaDisplayToLogical in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param _val represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://PC:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=User.Direccion#nombreviaDisplayToLogical"> Method nombreviaDisplayToLogical</A>
    */
    public static java.lang.String nombreviaDisplayToLogical (com.intersys.objects.Database db, java.lang.String _val) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(_val);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"nombreviaDisplayToLogical",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method nombreviaIsValid in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param _val represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://PC:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=User.Direccion#nombreviaIsValid"> Method nombreviaIsValid</A>
    */
    public static void nombreviaIsValid (com.intersys.objects.Database db, java.lang.String _val) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(_val);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"nombreviaIsValid",args,com.intersys.objects.Database.RET_PRIM);
        db.parseStatus(res);
        return;
    }
    /**
     <p>Runs method nombreviaLogicalToDisplay in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param _val represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://PC:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=User.Direccion#nombreviaLogicalToDisplay"> Method nombreviaLogicalToDisplay</A>
    */
    public static java.lang.String nombreviaLogicalToDisplay (com.intersys.objects.Database db, java.lang.String _val) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(_val);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"nombreviaLogicalToDisplay",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method numeroDisplayToLogical in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param _val represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://PC:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=User.Direccion#numeroDisplayToLogical"> Method numeroDisplayToLogical</A>
    */
    public static java.lang.Integer numeroDisplayToLogical (com.intersys.objects.Database db, java.lang.String _val) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(_val);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"numeroDisplayToLogical",args,com.intersys.objects.Database.RET_PRIM);
        return res.getInteger();
    }
    /**
     <p>Runs method numeroIsValid in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param _val represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://PC:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=User.Direccion#numeroIsValid"> Method numeroIsValid</A>
    */
    public static void numeroIsValid (com.intersys.objects.Database db, java.lang.String _val) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(_val);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"numeroIsValid",args,com.intersys.objects.Database.RET_PRIM);
        db.parseStatus(res);
        return;
    }
    /**
     <p>Runs method numeroLogicalToDisplay in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param _val represented as java.lang.Integer
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://PC:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=User.Direccion#numeroLogicalToDisplay"> Method numeroLogicalToDisplay</A>
    */
    public static java.lang.String numeroLogicalToDisplay (com.intersys.objects.Database db, java.lang.Integer _val) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(_val);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"numeroLogicalToDisplay",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method paisDisplayToLogical in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param _val represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://PC:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=User.Direccion#paisDisplayToLogical"> Method paisDisplayToLogical</A>
    */
    public static java.lang.String paisDisplayToLogical (com.intersys.objects.Database db, java.lang.String _val) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(_val);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"paisDisplayToLogical",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method paisIsValid in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param _val represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://PC:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=User.Direccion#paisIsValid"> Method paisIsValid</A>
    */
    public static void paisIsValid (com.intersys.objects.Database db, java.lang.String _val) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(_val);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"paisIsValid",args,com.intersys.objects.Database.RET_PRIM);
        db.parseStatus(res);
        return;
    }
    /**
     <p>Runs method paisLogicalToDisplay in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param _val represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://PC:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=User.Direccion#paisLogicalToDisplay"> Method paisLogicalToDisplay</A>
    */
    public static java.lang.String paisLogicalToDisplay (com.intersys.objects.Database db, java.lang.String _val) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(_val);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"paisLogicalToDisplay",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method provinciaDisplayToLogical in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param _val represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://PC:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=User.Direccion#provinciaDisplayToLogical"> Method provinciaDisplayToLogical</A>
    */
    public static java.lang.String provinciaDisplayToLogical (com.intersys.objects.Database db, java.lang.String _val) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(_val);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"provinciaDisplayToLogical",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method provinciaIsValid in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param _val represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://PC:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=User.Direccion#provinciaIsValid"> Method provinciaIsValid</A>
    */
    public static void provinciaIsValid (com.intersys.objects.Database db, java.lang.String _val) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(_val);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"provinciaIsValid",args,com.intersys.objects.Database.RET_PRIM);
        db.parseStatus(res);
        return;
    }
    /**
     <p>Runs method provinciaLogicalToDisplay in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param _val represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://PC:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=User.Direccion#provinciaLogicalToDisplay"> Method provinciaLogicalToDisplay</A>
    */
    public static java.lang.String provinciaLogicalToDisplay (com.intersys.objects.Database db, java.lang.String _val) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(_val);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"provinciaLogicalToDisplay",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method regionDisplayToLogical in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param _val represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://PC:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=User.Direccion#regionDisplayToLogical"> Method regionDisplayToLogical</A>
    */
    public static java.lang.String regionDisplayToLogical (com.intersys.objects.Database db, java.lang.String _val) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(_val);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"regionDisplayToLogical",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method regionIsValid in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param _val represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://PC:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=User.Direccion#regionIsValid"> Method regionIsValid</A>
    */
    public static void regionIsValid (com.intersys.objects.Database db, java.lang.String _val) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(_val);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"regionIsValid",args,com.intersys.objects.Database.RET_PRIM);
        db.parseStatus(res);
        return;
    }
    /**
     <p>Runs method regionLogicalToDisplay in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param _val represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://PC:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=User.Direccion#regionLogicalToDisplay"> Method regionLogicalToDisplay</A>
    */
    public static java.lang.String regionLogicalToDisplay (com.intersys.objects.Database db, java.lang.String _val) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(_val);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"regionLogicalToDisplay",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method tipoviaDisplayToLogical in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param _val represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://PC:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=User.Direccion#tipoviaDisplayToLogical"> Method tipoviaDisplayToLogical</A>
    */
    public static java.lang.String tipoviaDisplayToLogical (com.intersys.objects.Database db, java.lang.String _val) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(_val);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"tipoviaDisplayToLogical",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method tipoviaIsValid in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param _val represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://PC:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=User.Direccion#tipoviaIsValid"> Method tipoviaIsValid</A>
    */
    public static void tipoviaIsValid (com.intersys.objects.Database db, java.lang.String _val) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(_val);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"tipoviaIsValid",args,com.intersys.objects.Database.RET_PRIM);
        db.parseStatus(res);
        return;
    }
    /**
     <p>Runs method tipoviaLogicalToDisplay in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param _val represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://PC:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=User.Direccion#tipoviaLogicalToDisplay"> Method tipoviaLogicalToDisplay</A>
    */
    public static java.lang.String tipoviaLogicalToDisplay (com.intersys.objects.Database db, java.lang.String _val) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(_val);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"tipoviaLogicalToDisplay",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
}
