// ============================================================================
//
// Copyright (c) 2006-2015, Talend SA
//
// Ce code source a été automatiquement généré par_Talend Open Studio for Data Integration
// / Soumis à la Licence Apache, Version 2.0 (la "Licence") ;
// votre utilisation de ce fichier doit respecter les termes de la Licence.
// Vous pouvez obtenir une copie de la Licence sur
// http://www.apache.org/licenses/LICENSE-2.0
// 
// Sauf lorsqu'explicitement prévu par la loi en vigueur ou accepté par écrit, le logiciel
// distribué sous la Licence est distribué "TEL QUEL",
// SANS GARANTIE OU CONDITION D'AUCUNE SORTE, expresse ou implicite.
// Consultez la Licence pour connaître la terminologie spécifique régissant les autorisations et
// les limites prévues par la Licence.

package imdb.factmovies_0_1;

import routines.Numeric;
import routines.DataOperation;
import routines.TalendDataGenerator;
import routines.TalendStringUtil;
import routines.TalendString;
import routines.StringHandling;
import routines.Relational;
import routines.TalendDate;
import routines.Mathematical;
import routines.system.*;
import routines.system.api.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Comparator;

@SuppressWarnings("unused")

/**
 * Job: factMovies Purpose: <br>
 * Description: <br>
 * 
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status
 */
public class factMovies implements TalendJob {

	protected static void logIgnoredError(String message, Throwable cause) {
		System.err.println(message);
		if (cause != null) {
			cause.printStackTrace();
		}

	}

	public final Object obj = new Object();

	// for transmiting parameters purpose
	private Object valueObject = null;

	public Object getValueObject() {
		return this.valueObject;
	}

	public void setValueObject(Object valueObject) {
		this.valueObject = valueObject;
	}

	private final static String defaultCharset = java.nio.charset.Charset.defaultCharset().name();

	private final static String utf8Charset = "UTF-8";

	// contains type for every context property
	public class PropertiesWithType extends java.util.Properties {
		private static final long serialVersionUID = 1L;
		private java.util.Map<String, String> propertyTypes = new java.util.HashMap<>();

		public PropertiesWithType(java.util.Properties properties) {
			super(properties);
		}

		public PropertiesWithType() {
			super();
		}

		public void setContextType(String key, String type) {
			propertyTypes.put(key, type);
		}

		public String getContextType(String key) {
			return propertyTypes.get(key);
		}
	}

	// create and load default properties
	private java.util.Properties defaultProps = new java.util.Properties();

	// create application properties with default
	public class ContextProperties extends PropertiesWithType {

		private static final long serialVersionUID = 1L;

		public ContextProperties(java.util.Properties properties) {
			super(properties);
		}

		public ContextProperties() {
			super();
		}

		public void synchronizeContext() {

		}

		// if the stored or passed value is "<TALEND_NULL>" string, it mean null
		public String getStringValue(String key) {
			String origin_value = this.getProperty(key);
			if (NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY.equals(origin_value)) {
				return null;
			}
			return origin_value;
		}

	}

	protected ContextProperties context = new ContextProperties(); // will be instanciated by MS.

	public ContextProperties getContext() {
		return this.context;
	}

	private final String jobVersion = "0.1";
	private final String jobName = "factMovies";
	private final String projectName = "IMDB";
	public Integer errorCode = null;
	private String currentComponent = "";

	private final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
	private final static java.util.Map<String, Object> junitGlobalMap = new java.util.HashMap<String, Object>();

	private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
	public final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();

	private RunStat runStat = new RunStat();

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";

	private final static String KEY_DB_DATASOURCES_RAW = "KEY_DB_DATASOURCES_RAW";

	public void setDataSources(java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources.entrySet()) {
			talendDataSources.put(dataSourceEntry.getKey(),
					new routines.system.TalendDataSource(dataSourceEntry.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}

	public void setDataSourceReferences(List serviceReferences) throws Exception {

		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		java.util.Map<String, javax.sql.DataSource> dataSources = new java.util.HashMap<String, javax.sql.DataSource>();

		for (java.util.Map.Entry<String, javax.sql.DataSource> entry : BundleUtils
				.getServices(serviceReferences, javax.sql.DataSource.class).entrySet()) {
			dataSources.put(entry.getKey(), entry.getValue());
			talendDataSources.put(entry.getKey(), new routines.system.TalendDataSource(entry.getValue()));
		}

		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}

	private final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
	private final java.io.PrintStream errorMessagePS = new java.io.PrintStream(new java.io.BufferedOutputStream(baos));

	public String getExceptionStackTrace() {
		if ("failure".equals(this.getStatus())) {
			errorMessagePS.flush();
			return baos.toString();
		}
		return null;
	}

	private Exception exception;

	public Exception getException() {
		if ("failure".equals(this.getStatus())) {
			return this.exception;
		}
		return null;
	}

	private class TalendException extends Exception {

		private static final long serialVersionUID = 1L;

		private java.util.Map<String, Object> globalMap = null;
		private Exception e = null;
		private String currentComponent = null;
		private String virtualComponentName = null;

		public void setVirtualComponentName(String virtualComponentName) {
			this.virtualComponentName = virtualComponentName;
		}

		private TalendException(Exception e, String errorComponent, final java.util.Map<String, Object> globalMap) {
			this.currentComponent = errorComponent;
			this.globalMap = globalMap;
			this.e = e;
		}

		public Exception getException() {
			return this.e;
		}

		public String getCurrentComponent() {
			return this.currentComponent;
		}

		public String getExceptionCauseMessage(Exception e) {
			Throwable cause = e;
			String message = null;
			int i = 10;
			while (null != cause && 0 < i--) {
				message = cause.getMessage();
				if (null == message) {
					cause = cause.getCause();
				} else {
					break;
				}
			}
			if (null == message) {
				message = e.getClass().getName();
			}
			return message;
		}

		@Override
		public void printStackTrace() {
			if (!(e instanceof TalendException || e instanceof TDieException)) {
				if (virtualComponentName != null && currentComponent.indexOf(virtualComponentName + "_") == 0) {
					globalMap.put(virtualComponentName + "_ERROR_MESSAGE", getExceptionCauseMessage(e));
				}
				globalMap.put(currentComponent + "_ERROR_MESSAGE", getExceptionCauseMessage(e));
				System.err.println("Exception in component " + currentComponent + " (" + jobName + ")");
			}
			if (!(e instanceof TDieException)) {
				if (e instanceof TalendException) {
					e.printStackTrace();
				} else {
					e.printStackTrace();
					e.printStackTrace(errorMessagePS);
					factMovies.this.exception = e;
				}
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(factMovies.this, new Object[] { e, currentComponent, globalMap });
							break;
						}
					}

					if (!(e instanceof TDieException)) {
					}
				} catch (Exception e) {
					this.e.printStackTrace();
				}
			}
		}
	}

	public void tFileInputDelimited_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_5_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_7_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_4_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_5_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBOutput_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_5_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFileInputDelimited_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFileInputDelimited_3_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFileInputDelimited_4_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFileInputDelimited_5_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_5_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_6_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_5_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tAdvancedHash_actor_movie_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tAdvancedHash_actor_movie_writer_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tAdvancedHash_Movies_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tAdvancedHash_row4_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFileInputDelimited_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tFileInputDelimited_2_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tFileInputDelimited_3_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tFileInputDelimited_5_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public static class actor_movieStruct
			implements routines.system.IPersistableComparableLookupRow<actor_movieStruct> {
		final static byte[] commonByteArrayLock_IMDB_factMovies = new byte[0];
		static byte[] commonByteArray_IMDB_factMovies = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public String IdActor;

		public String getIdActor() {
			return this.IdActor;
		}

		public String IdMovie;

		public String getIdMovie() {
			return this.IdMovie;
		}

		public Integer IdDate;

		public Integer getIdDate() {
			return this.IdDate;
		}

		public String runtimeMinutes_1;

		public String getRuntimeMinutes_1() {
			return this.runtimeMinutes_1;
		}

		public String Revenue__Millions;

		public String getRevenue__Millions() {
			return this.Revenue__Millions;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + ((this.IdMovie == null) ? 0 : this.IdMovie.hashCode());

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final actor_movieStruct other = (actor_movieStruct) obj;

			if (this.IdMovie == null) {
				if (other.IdMovie != null)
					return false;

			} else if (!this.IdMovie.equals(other.IdMovie))

				return false;

			return true;
		}

		public void copyDataTo(actor_movieStruct other) {

			other.IdActor = this.IdActor;
			other.IdMovie = this.IdMovie;
			other.IdDate = this.IdDate;
			other.runtimeMinutes_1 = this.runtimeMinutes_1;
			other.Revenue__Millions = this.Revenue__Millions;

		}

		public void copyKeysDataTo(actor_movieStruct other) {

			other.IdMovie = this.IdMovie;

		}

		private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				byte[] byteArray = new byte[length];
				dis.read(byteArray);
				strReturn = new String(byteArray, utf8Charset);
			}
			return strReturn;
		}

		private String readString(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller)
				throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				byte[] byteArray = new byte[length];
				unmarshaller.read(byteArray);
				strReturn = new String(byteArray, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller)
				throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_IMDB_factMovies.length) {
					if (length < 1024 && commonByteArray_IMDB_factMovies.length == 0) {
						commonByteArray_IMDB_factMovies = new byte[1024];
					} else {
						commonByteArray_IMDB_factMovies = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_IMDB_factMovies, 0, length);
				strReturn = new String(commonByteArray_IMDB_factMovies, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_IMDB_factMovies.length) {
					if (length < 1024 && commonByteArray_IMDB_factMovies.length == 0) {
						commonByteArray_IMDB_factMovies = new byte[1024];
					} else {
						commonByteArray_IMDB_factMovies = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_IMDB_factMovies, 0, length);
				strReturn = new String(commonByteArray_IMDB_factMovies, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private Integer readInteger(DataInputStream dis, ObjectInputStream ois) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller)
				throws IOException {
			Integer intReturn;
			int length = 0;
			length = unmarshaller.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = unmarshaller.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, DataOutputStream dos, ObjectOutputStream oos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller)
				throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		public void readKeysData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_IMDB_factMovies) {

				try {

					int length = 0;

					this.IdMovie = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_IMDB_factMovies) {

				try {

					int length = 0;

					this.IdMovie = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeKeysData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.IdMovie, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.IdMovie, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		/**
		 * Fill Values data by reading ObjectInputStream.
		 */
		public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
			try {

				int length = 0;

				this.IdActor = readString(dis, ois);

				this.IdDate = readInteger(dis, ois);

				this.runtimeMinutes_1 = readString(dis, ois);

				this.Revenue__Millions = readString(dis, ois);

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
			try {
				int length = 0;

				this.IdActor = readString(dis, objectIn);

				this.IdDate = readInteger(dis, objectIn);

				this.runtimeMinutes_1 = readString(dis, objectIn);

				this.Revenue__Millions = readString(dis, objectIn);

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		/**
		 * Return a byte array which represents Values data.
		 */
		public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
			try {

				writeString(this.IdActor, dos, oos);

				writeInteger(this.IdDate, dos, oos);

				writeString(this.runtimeMinutes_1, dos, oos);

				writeString(this.Revenue__Millions, dos, oos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut) {
			try {

				writeString(this.IdActor, dos, objectOut);

				writeInteger(this.IdDate, dos, objectOut);

				writeString(this.runtimeMinutes_1, dos, objectOut);

				writeString(this.Revenue__Millions, dos, objectOut);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		public boolean supportMarshaller() {
			return true;
		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("IdActor=" + IdActor);
			sb.append(",IdMovie=" + IdMovie);
			sb.append(",IdDate=" + String.valueOf(IdDate));
			sb.append(",runtimeMinutes_1=" + runtimeMinutes_1);
			sb.append(",Revenue__Millions=" + Revenue__Millions);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(actor_movieStruct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.IdMovie, other.IdMovie);
			if (returnValue != 0) {
				return returnValue;
			}

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class actorsStruct implements routines.system.IPersistableRow<actorsStruct> {
		final static byte[] commonByteArrayLock_IMDB_factMovies = new byte[0];
		static byte[] commonByteArray_IMDB_factMovies = new byte[0];

		public String nconst;

		public String getNconst() {
			return this.nconst;
		}

		public String primaryName;

		public String getPrimaryName() {
			return this.primaryName;
		}

		public String genre;

		public String getGenre() {
			return this.genre;
		}

		public String titles;

		public String getTitles() {
			return this.titles;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_IMDB_factMovies.length) {
					if (length < 1024 && commonByteArray_IMDB_factMovies.length == 0) {
						commonByteArray_IMDB_factMovies = new byte[1024];
					} else {
						commonByteArray_IMDB_factMovies = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_IMDB_factMovies, 0, length);
				strReturn = new String(commonByteArray_IMDB_factMovies, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_IMDB_factMovies.length) {
					if (length < 1024 && commonByteArray_IMDB_factMovies.length == 0) {
						commonByteArray_IMDB_factMovies = new byte[1024];
					} else {
						commonByteArray_IMDB_factMovies = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_IMDB_factMovies, 0, length);
				strReturn = new String(commonByteArray_IMDB_factMovies, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_IMDB_factMovies) {

				try {

					int length = 0;

					this.nconst = readString(dis);

					this.primaryName = readString(dis);

					this.genre = readString(dis);

					this.titles = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_IMDB_factMovies) {

				try {

					int length = 0;

					this.nconst = readString(dis);

					this.primaryName = readString(dis);

					this.genre = readString(dis);

					this.titles = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.nconst, dos);

				// String

				writeString(this.primaryName, dos);

				// String

				writeString(this.genre, dos);

				// String

				writeString(this.titles, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.nconst, dos);

				// String

				writeString(this.primaryName, dos);

				// String

				writeString(this.genre, dos);

				// String

				writeString(this.titles, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("nconst=" + nconst);
			sb.append(",primaryName=" + primaryName);
			sb.append(",genre=" + genre);
			sb.append(",titles=" + titles);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(actorsStruct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
		final static byte[] commonByteArrayLock_IMDB_factMovies = new byte[0];
		static byte[] commonByteArray_IMDB_factMovies = new byte[0];

		public String nconst;

		public String getNconst() {
			return this.nconst;
		}

		public String primaryName;

		public String getPrimaryName() {
			return this.primaryName;
		}

		public Integer birthYear;

		public Integer getBirthYear() {
			return this.birthYear;
		}

		public String deathYear;

		public String getDeathYear() {
			return this.deathYear;
		}

		public String primaryProfession;

		public String getPrimaryProfession() {
			return this.primaryProfession;
		}

		public String knownForTitles;

		public String getKnownForTitles() {
			return this.knownForTitles;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_IMDB_factMovies.length) {
					if (length < 1024 && commonByteArray_IMDB_factMovies.length == 0) {
						commonByteArray_IMDB_factMovies = new byte[1024];
					} else {
						commonByteArray_IMDB_factMovies = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_IMDB_factMovies, 0, length);
				strReturn = new String(commonByteArray_IMDB_factMovies, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_IMDB_factMovies.length) {
					if (length < 1024 && commonByteArray_IMDB_factMovies.length == 0) {
						commonByteArray_IMDB_factMovies = new byte[1024];
					} else {
						commonByteArray_IMDB_factMovies = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_IMDB_factMovies, 0, length);
				strReturn = new String(commonByteArray_IMDB_factMovies, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_IMDB_factMovies) {

				try {

					int length = 0;

					this.nconst = readString(dis);

					this.primaryName = readString(dis);

					this.birthYear = readInteger(dis);

					this.deathYear = readString(dis);

					this.primaryProfession = readString(dis);

					this.knownForTitles = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_IMDB_factMovies) {

				try {

					int length = 0;

					this.nconst = readString(dis);

					this.primaryName = readString(dis);

					this.birthYear = readInteger(dis);

					this.deathYear = readString(dis);

					this.primaryProfession = readString(dis);

					this.knownForTitles = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.nconst, dos);

				// String

				writeString(this.primaryName, dos);

				// Integer

				writeInteger(this.birthYear, dos);

				// String

				writeString(this.deathYear, dos);

				// String

				writeString(this.primaryProfession, dos);

				// String

				writeString(this.knownForTitles, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.nconst, dos);

				// String

				writeString(this.primaryName, dos);

				// Integer

				writeInteger(this.birthYear, dos);

				// String

				writeString(this.deathYear, dos);

				// String

				writeString(this.primaryProfession, dos);

				// String

				writeString(this.knownForTitles, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("nconst=" + nconst);
			sb.append(",primaryName=" + primaryName);
			sb.append(",birthYear=" + String.valueOf(birthYear));
			sb.append(",deathYear=" + deathYear);
			sb.append(",primaryProfession=" + primaryProfession);
			sb.append(",knownForTitles=" + knownForTitles);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row1Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class after_tFileInputDelimited_1Struct
			implements routines.system.IPersistableRow<after_tFileInputDelimited_1Struct> {
		final static byte[] commonByteArrayLock_IMDB_factMovies = new byte[0];
		static byte[] commonByteArray_IMDB_factMovies = new byte[0];

		public String nconst;

		public String getNconst() {
			return this.nconst;
		}

		public String primaryName;

		public String getPrimaryName() {
			return this.primaryName;
		}

		public Integer birthYear;

		public Integer getBirthYear() {
			return this.birthYear;
		}

		public String deathYear;

		public String getDeathYear() {
			return this.deathYear;
		}

		public String primaryProfession;

		public String getPrimaryProfession() {
			return this.primaryProfession;
		}

		public String knownForTitles;

		public String getKnownForTitles() {
			return this.knownForTitles;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_IMDB_factMovies.length) {
					if (length < 1024 && commonByteArray_IMDB_factMovies.length == 0) {
						commonByteArray_IMDB_factMovies = new byte[1024];
					} else {
						commonByteArray_IMDB_factMovies = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_IMDB_factMovies, 0, length);
				strReturn = new String(commonByteArray_IMDB_factMovies, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_IMDB_factMovies.length) {
					if (length < 1024 && commonByteArray_IMDB_factMovies.length == 0) {
						commonByteArray_IMDB_factMovies = new byte[1024];
					} else {
						commonByteArray_IMDB_factMovies = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_IMDB_factMovies, 0, length);
				strReturn = new String(commonByteArray_IMDB_factMovies, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_IMDB_factMovies) {

				try {

					int length = 0;

					this.nconst = readString(dis);

					this.primaryName = readString(dis);

					this.birthYear = readInteger(dis);

					this.deathYear = readString(dis);

					this.primaryProfession = readString(dis);

					this.knownForTitles = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_IMDB_factMovies) {

				try {

					int length = 0;

					this.nconst = readString(dis);

					this.primaryName = readString(dis);

					this.birthYear = readInteger(dis);

					this.deathYear = readString(dis);

					this.primaryProfession = readString(dis);

					this.knownForTitles = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.nconst, dos);

				// String

				writeString(this.primaryName, dos);

				// Integer

				writeInteger(this.birthYear, dos);

				// String

				writeString(this.deathYear, dos);

				// String

				writeString(this.primaryProfession, dos);

				// String

				writeString(this.knownForTitles, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.nconst, dos);

				// String

				writeString(this.primaryName, dos);

				// Integer

				writeInteger(this.birthYear, dos);

				// String

				writeString(this.deathYear, dos);

				// String

				writeString(this.primaryProfession, dos);

				// String

				writeString(this.knownForTitles, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("nconst=" + nconst);
			sb.append(",primaryName=" + primaryName);
			sb.append(",birthYear=" + String.valueOf(birthYear));
			sb.append(",deathYear=" + deathYear);
			sb.append(",primaryProfession=" + primaryProfession);
			sb.append(",knownForTitles=" + knownForTitles);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(after_tFileInputDelimited_1Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tFileInputDelimited_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tFileInputDelimited_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				tFileInputDelimited_2Process(globalMap);

				row1Struct row1 = new row1Struct();
				actorsStruct actors = new actorsStruct();
				actor_movieStruct actor_movie = new actor_movieStruct();

				/**
				 * [tAdvancedHash_actor_movie begin ] start
				 */

				ok_Hash.put("tAdvancedHash_actor_movie", false);
				start_Hash.put("tAdvancedHash_actor_movie", System.currentTimeMillis());

				currentComponent = "tAdvancedHash_actor_movie";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "actor_movie");
				}

				int tos_count_tAdvancedHash_actor_movie = 0;

				// connection name:actor_movie
				// source node:tMap_5 - inputs:(actors,Movies) outputs:(actor_movie,actor_movie)
				// | target node:tAdvancedHash_actor_movie - inputs:(actor_movie) outputs:()
				// linked node: tMap_7 - inputs:(actor_movie,Writers)
				// outputs:(actor_movie_writer,actor_movie_writer)

				org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_actor_movie = org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.ALL_MATCHES;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<actor_movieStruct> tHash_Lookup_actor_movie = org.talend.designer.components.lookup.memory.AdvancedMemoryLookup
						.<actor_movieStruct>getLookup(matchingModeEnum_actor_movie);

				globalMap.put("tHash_Lookup_actor_movie", tHash_Lookup_actor_movie);

				/**
				 * [tAdvancedHash_actor_movie begin ] stop
				 */

				/**
				 * [tMap_5 begin ] start
				 */

				ok_Hash.put("tMap_5", false);
				start_Hash.put("tMap_5", System.currentTimeMillis());

				currentComponent = "tMap_5";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "actors");
				}

				int tos_count_tMap_5 = 0;

// ###############################
// # Lookup's keys initialization

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<MoviesStruct> tHash_Lookup_Movies = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<MoviesStruct>) ((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<MoviesStruct>) globalMap
						.get("tHash_Lookup_Movies"));

				MoviesStruct MoviesHashKey = new MoviesStruct();
				MoviesStruct MoviesDefault = new MoviesStruct();
// ###############################        

// ###############################
// # Vars initialization
				class Var__tMap_5__Struct {
				}
				Var__tMap_5__Struct Var__tMap_5 = new Var__tMap_5__Struct();
// ###############################

// ###############################
// # Outputs initialization
				actor_movieStruct actor_movie_tmp = new actor_movieStruct();
// ###############################

				/**
				 * [tMap_5 begin ] stop
				 */

				/**
				 * [tMap_1 begin ] start
				 */

				ok_Hash.put("tMap_1", false);
				start_Hash.put("tMap_1", System.currentTimeMillis());

				currentComponent = "tMap_1";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row1");
				}

				int tos_count_tMap_1 = 0;

// ###############################
// # Lookup's keys initialization
// ###############################        

// ###############################
// # Vars initialization
				class Var__tMap_1__Struct {
					String genre;
					String title;
				}
				Var__tMap_1__Struct Var__tMap_1 = new Var__tMap_1__Struct();
// ###############################

// ###############################
// # Outputs initialization
				actorsStruct actors_tmp = new actorsStruct();
// ###############################

				/**
				 * [tMap_1 begin ] stop
				 */

				/**
				 * [tFileInputDelimited_1 begin ] start
				 */

				ok_Hash.put("tFileInputDelimited_1", false);
				start_Hash.put("tFileInputDelimited_1", System.currentTimeMillis());

				currentComponent = "tFileInputDelimited_1";

				int tos_count_tFileInputDelimited_1 = 0;

				final routines.system.RowState rowstate_tFileInputDelimited_1 = new routines.system.RowState();

				int nb_line_tFileInputDelimited_1 = 0;
				org.talend.fileprocess.FileInputDelimited fid_tFileInputDelimited_1 = null;
				int limit_tFileInputDelimited_1 = 500000;
				try {

					Object filename_tFileInputDelimited_1 = "C:/Users/ZMERLI/Downloads/imdb dataset/name.basics.tsv/name.basics.tsv";
					if (filename_tFileInputDelimited_1 instanceof java.io.InputStream) {

						int footer_value_tFileInputDelimited_1 = 0, random_value_tFileInputDelimited_1 = -1;
						if (footer_value_tFileInputDelimited_1 > 0 || random_value_tFileInputDelimited_1 > 0) {
							throw new java.lang.Exception(
									"When the input source is a stream,footer and random shouldn't be bigger than 0.");
						}

					}
					try {
						fid_tFileInputDelimited_1 = new org.talend.fileprocess.FileInputDelimited(
								"C:/Users/ZMERLI/Downloads/imdb dataset/name.basics.tsv/name.basics.tsv", "US-ASCII",
								"\t", "\n", false, 1, 0, limit_tFileInputDelimited_1, -1, false);
					} catch (java.lang.Exception e) {
						globalMap.put("tFileInputDelimited_1_ERROR_MESSAGE", e.getMessage());

						System.err.println(e.getMessage());

					}

					while (fid_tFileInputDelimited_1 != null && fid_tFileInputDelimited_1.nextRecord()) {
						rowstate_tFileInputDelimited_1.reset();

						row1 = null;

						boolean whetherReject_tFileInputDelimited_1 = false;
						row1 = new row1Struct();
						try {

							int columnIndexWithD_tFileInputDelimited_1 = 0;

							String temp = "";

							columnIndexWithD_tFileInputDelimited_1 = 0;

							row1.nconst = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);

							columnIndexWithD_tFileInputDelimited_1 = 1;

							row1.primaryName = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);

							columnIndexWithD_tFileInputDelimited_1 = 2;

							temp = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
							if (temp.length() > 0) {

								try {

									row1.birthYear = ParserUtils.parseTo_Integer(temp);

								} catch (java.lang.Exception ex_tFileInputDelimited_1) {
									globalMap.put("tFileInputDelimited_1_ERROR_MESSAGE",
											ex_tFileInputDelimited_1.getMessage());
									rowstate_tFileInputDelimited_1.setException(new RuntimeException(String.format(
											"Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
											"birthYear", "row1", temp, ex_tFileInputDelimited_1),
											ex_tFileInputDelimited_1));
								}

							} else {

								row1.birthYear = null;

							}

							columnIndexWithD_tFileInputDelimited_1 = 3;

							row1.deathYear = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);

							columnIndexWithD_tFileInputDelimited_1 = 4;

							row1.primaryProfession = fid_tFileInputDelimited_1
									.get(columnIndexWithD_tFileInputDelimited_1);

							columnIndexWithD_tFileInputDelimited_1 = 5;

							row1.knownForTitles = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);

							if (rowstate_tFileInputDelimited_1.getException() != null) {
								throw rowstate_tFileInputDelimited_1.getException();
							}

						} catch (java.lang.Exception e) {
							globalMap.put("tFileInputDelimited_1_ERROR_MESSAGE", e.getMessage());
							whetherReject_tFileInputDelimited_1 = true;

							System.err.println(e.getMessage());
							row1 = null;

						}

						/**
						 * [tFileInputDelimited_1 begin ] stop
						 */

						/**
						 * [tFileInputDelimited_1 main ] start
						 */

						currentComponent = "tFileInputDelimited_1";

						tos_count_tFileInputDelimited_1++;

						/**
						 * [tFileInputDelimited_1 main ] stop
						 */

						/**
						 * [tFileInputDelimited_1 process_data_begin ] start
						 */

						currentComponent = "tFileInputDelimited_1";

						/**
						 * [tFileInputDelimited_1 process_data_begin ] stop
						 */
// Start of branch "row1"
						if (row1 != null) {

							/**
							 * [tMap_1 main ] start
							 */

							currentComponent = "tMap_1";

							if (execStat) {
								runStat.updateStatOnConnection(iterateId, 1, 1

										, "row1"

								);
							}

							boolean hasCasePrimitiveKeyWithNull_tMap_1 = false;

							// ###############################
							// # Input tables (lookups)
							boolean rejectedInnerJoin_tMap_1 = false;
							boolean mainRowRejected_tMap_1 = false;

							if (

							(

							(row1.primaryProfession.contains("actor") || row1.primaryProfession.contains("actress"))
									&& !row1.birthYear.equals("\\N")

							)

							) { // G_TM_M_280

								// CALL close main tMap filter for table 'row1'
								// ###############################
								{ // start of Var scope

									// ###############################
									// # Vars tables

									Var__tMap_1__Struct Var = Var__tMap_1;
									Var.genre = row1.primaryProfession.contains("actor") ? "male" : "female";
									;
									Var.title = row1.knownForTitles.split(",")[0];// ###############################
									// ###############################
									// # Output tables

									actors = null;

// # Output table : 'actors'
									actors_tmp.nconst = row1.nconst;
									actors_tmp.primaryName = row1.primaryName;
									actors_tmp.genre = Var.genre;
									actors_tmp.titles = Var.title;
									actors = actors_tmp;
// ###############################

								} // end of Var scope

								rejectedInnerJoin_tMap_1 = false;

								tos_count_tMap_1++;

								/**
								 * [tMap_1 main ] stop
								 */

								/**
								 * [tMap_1 process_data_begin ] start
								 */

								currentComponent = "tMap_1";

								/**
								 * [tMap_1 process_data_begin ] stop
								 */
// Start of branch "actors"
								if (actors != null) {

									/**
									 * [tMap_5 main ] start
									 */

									currentComponent = "tMap_5";

									if (execStat) {
										runStat.updateStatOnConnection(iterateId, 1, 1

												, "actors"

										);
									}

									boolean hasCasePrimitiveKeyWithNull_tMap_5 = false;

									// ###############################
									// # Input tables (lookups)
									boolean rejectedInnerJoin_tMap_5 = false;
									boolean mainRowRejected_tMap_5 = false;

									///////////////////////////////////////////////
									// Starting Lookup Table "Movies"
									///////////////////////////////////////////////

									boolean forceLoopMovies = false;

									MoviesStruct MoviesObjectFromLookup = null;

									if (!rejectedInnerJoin_tMap_5) { // G_TM_M_020

										hasCasePrimitiveKeyWithNull_tMap_5 = false;

										MoviesHashKey.tconst = actors.titles;

										MoviesHashKey.hashCodeDirty = true;

										tHash_Lookup_Movies.lookup(MoviesHashKey);

										if (!tHash_Lookup_Movies.hasNext()) { // G_TM_M_090

											rejectedInnerJoin_tMap_5 = true;

											forceLoopMovies = true;

										} // G_TM_M_090

									} // G_TM_M_020

									else { // G 20 - G 21
										forceLoopMovies = true;
									} // G 21

									MoviesStruct Movies = null;

									while ((tHash_Lookup_Movies != null && tHash_Lookup_Movies.hasNext())
											|| forceLoopMovies) { // G_TM_M_043

										// CALL close loop of lookup 'Movies'

										MoviesStruct fromLookup_Movies = null;
										Movies = MoviesDefault;

										if (!forceLoopMovies) { // G 46

											fromLookup_Movies = tHash_Lookup_Movies.next();

											if (fromLookup_Movies != null) {
												Movies = fromLookup_Movies;
											}

										} // G 46

										forceLoopMovies = false;

										// ###############################
										{ // start of Var scope

											// ###############################
											// # Vars tables

											Var__tMap_5__Struct Var = Var__tMap_5;// ###############################
											// ###############################
											// # Output tables

											actor_movie = null;

											if (!rejectedInnerJoin_tMap_5) {

// # Output table : 'actor_movie'
												actor_movie_tmp.IdActor = actors.nconst;
												actor_movie_tmp.IdMovie = Movies.tconst;
												actor_movie_tmp.IdDate = Movies.IdDate;
												actor_movie_tmp.runtimeMinutes_1 = Movies.runtimeMinutes_1;
												actor_movie_tmp.Revenue__Millions = Movies.Revenue__Millions;
												actor_movie = actor_movie_tmp;
											} // closing inner join bracket (2)
// ###############################

										} // end of Var scope

										rejectedInnerJoin_tMap_5 = false;

										tos_count_tMap_5++;

										/**
										 * [tMap_5 main ] stop
										 */

										/**
										 * [tMap_5 process_data_begin ] start
										 */

										currentComponent = "tMap_5";

										/**
										 * [tMap_5 process_data_begin ] stop
										 */
// Start of branch "actor_movie"
										if (actor_movie != null) {

											/**
											 * [tAdvancedHash_actor_movie main ] start
											 */

											currentComponent = "tAdvancedHash_actor_movie";

											if (execStat) {
												runStat.updateStatOnConnection(iterateId, 1, 1

														, "actor_movie"

												);
											}

											actor_movieStruct actor_movie_HashRow = new actor_movieStruct();

											actor_movie_HashRow.IdActor = actor_movie.IdActor;

											actor_movie_HashRow.IdMovie = actor_movie.IdMovie;

											actor_movie_HashRow.IdDate = actor_movie.IdDate;

											actor_movie_HashRow.runtimeMinutes_1 = actor_movie.runtimeMinutes_1;

											actor_movie_HashRow.Revenue__Millions = actor_movie.Revenue__Millions;

											tHash_Lookup_actor_movie.put(actor_movie_HashRow);

											tos_count_tAdvancedHash_actor_movie++;

											/**
											 * [tAdvancedHash_actor_movie main ] stop
											 */

											/**
											 * [tAdvancedHash_actor_movie process_data_begin ] start
											 */

											currentComponent = "tAdvancedHash_actor_movie";

											/**
											 * [tAdvancedHash_actor_movie process_data_begin ] stop
											 */

											/**
											 * [tAdvancedHash_actor_movie process_data_end ] start
											 */

											currentComponent = "tAdvancedHash_actor_movie";

											/**
											 * [tAdvancedHash_actor_movie process_data_end ] stop
											 */

										} // End of branch "actor_movie"

									} // close loop of lookup 'Movies' // G_TM_M_043

									/**
									 * [tMap_5 process_data_end ] start
									 */

									currentComponent = "tMap_5";

									/**
									 * [tMap_5 process_data_end ] stop
									 */

								} // End of branch "actors"

							} // G_TM_M_280 close main tMap filter for table 'row1'

							/**
							 * [tMap_1 process_data_end ] start
							 */

							currentComponent = "tMap_1";

							/**
							 * [tMap_1 process_data_end ] stop
							 */

						} // End of branch "row1"

						/**
						 * [tFileInputDelimited_1 process_data_end ] start
						 */

						currentComponent = "tFileInputDelimited_1";

						/**
						 * [tFileInputDelimited_1 process_data_end ] stop
						 */

						/**
						 * [tFileInputDelimited_1 end ] start
						 */

						currentComponent = "tFileInputDelimited_1";

					}
				} finally {
					if (!((Object) ("C:/Users/ZMERLI/Downloads/imdb dataset/name.basics.tsv/name.basics.tsv") instanceof java.io.InputStream)) {
						if (fid_tFileInputDelimited_1 != null) {
							fid_tFileInputDelimited_1.close();
						}
					}
					if (fid_tFileInputDelimited_1 != null) {
						globalMap.put("tFileInputDelimited_1_NB_LINE", fid_tFileInputDelimited_1.getRowNumber());

					}
				}

				ok_Hash.put("tFileInputDelimited_1", true);
				end_Hash.put("tFileInputDelimited_1", System.currentTimeMillis());

				/**
				 * [tFileInputDelimited_1 end ] stop
				 */

				/**
				 * [tMap_1 end ] start
				 */

				currentComponent = "tMap_1";

// ###############################
// # Lookup hashes releasing
// ###############################      

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row1");
				}

				ok_Hash.put("tMap_1", true);
				end_Hash.put("tMap_1", System.currentTimeMillis());

				/**
				 * [tMap_1 end ] stop
				 */

				/**
				 * [tMap_5 end ] start
				 */

				currentComponent = "tMap_5";

// ###############################
// # Lookup hashes releasing
				if (tHash_Lookup_Movies != null) {
					tHash_Lookup_Movies.endGet();
				}
				globalMap.remove("tHash_Lookup_Movies");

// ###############################      

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "actors");
				}

				ok_Hash.put("tMap_5", true);
				end_Hash.put("tMap_5", System.currentTimeMillis());

				/**
				 * [tMap_5 end ] stop
				 */

				/**
				 * [tAdvancedHash_actor_movie end ] start
				 */

				currentComponent = "tAdvancedHash_actor_movie";

				tHash_Lookup_actor_movie.endPut();

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "actor_movie");
				}

				ok_Hash.put("tAdvancedHash_actor_movie", true);
				end_Hash.put("tAdvancedHash_actor_movie", System.currentTimeMillis());

				/**
				 * [tAdvancedHash_actor_movie end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			// free memory for "tMap_5"
			globalMap.remove("tHash_Lookup_Movies");

			try {

				/**
				 * [tFileInputDelimited_1 finally ] start
				 */

				currentComponent = "tFileInputDelimited_1";

				/**
				 * [tFileInputDelimited_1 finally ] stop
				 */

				/**
				 * [tMap_1 finally ] start
				 */

				currentComponent = "tMap_1";

				/**
				 * [tMap_1 finally ] stop
				 */

				/**
				 * [tMap_5 finally ] start
				 */

				currentComponent = "tMap_5";

				/**
				 * [tMap_5 finally ] stop
				 */

				/**
				 * [tAdvancedHash_actor_movie finally ] start
				 */

				currentComponent = "tAdvancedHash_actor_movie";

				/**
				 * [tAdvancedHash_actor_movie finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tFileInputDelimited_1_SUBPROCESS_STATE", 1);
	}

	public static class MoviesStruct implements routines.system.IPersistableComparableLookupRow<MoviesStruct> {
		final static byte[] commonByteArrayLock_IMDB_factMovies = new byte[0];
		static byte[] commonByteArray_IMDB_factMovies = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public String tconst;

		public String getTconst() {
			return this.tconst;
		}

		public String primaryTitle;

		public String getPrimaryTitle() {
			return this.primaryTitle;
		}

		public String runtimeMinutes;

		public String getRuntimeMinutes() {
			return this.runtimeMinutes;
		}

		public String genres;

		public String getGenres() {
			return this.genres;
		}

		public Integer IdDate;

		public Integer getIdDate() {
			return this.IdDate;
		}

		public String runtimeMinutes_1;

		public String getRuntimeMinutes_1() {
			return this.runtimeMinutes_1;
		}

		public String Revenue__Millions;

		public String getRevenue__Millions() {
			return this.Revenue__Millions;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + ((this.tconst == null) ? 0 : this.tconst.hashCode());

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final MoviesStruct other = (MoviesStruct) obj;

			if (this.tconst == null) {
				if (other.tconst != null)
					return false;

			} else if (!this.tconst.equals(other.tconst))

				return false;

			return true;
		}

		public void copyDataTo(MoviesStruct other) {

			other.tconst = this.tconst;
			other.primaryTitle = this.primaryTitle;
			other.runtimeMinutes = this.runtimeMinutes;
			other.genres = this.genres;
			other.IdDate = this.IdDate;
			other.runtimeMinutes_1 = this.runtimeMinutes_1;
			other.Revenue__Millions = this.Revenue__Millions;

		}

		public void copyKeysDataTo(MoviesStruct other) {

			other.tconst = this.tconst;

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_IMDB_factMovies.length) {
					if (length < 1024 && commonByteArray_IMDB_factMovies.length == 0) {
						commonByteArray_IMDB_factMovies = new byte[1024];
					} else {
						commonByteArray_IMDB_factMovies = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_IMDB_factMovies, 0, length);
				strReturn = new String(commonByteArray_IMDB_factMovies, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_IMDB_factMovies.length) {
					if (length < 1024 && commonByteArray_IMDB_factMovies.length == 0) {
						commonByteArray_IMDB_factMovies = new byte[1024];
					} else {
						commonByteArray_IMDB_factMovies = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_IMDB_factMovies, 0, length);
				strReturn = new String(commonByteArray_IMDB_factMovies, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				byte[] byteArray = new byte[length];
				dis.read(byteArray);
				strReturn = new String(byteArray, utf8Charset);
			}
			return strReturn;
		}

		private String readString(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller)
				throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				byte[] byteArray = new byte[length];
				unmarshaller.read(byteArray);
				strReturn = new String(byteArray, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller)
				throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private Integer readInteger(DataInputStream dis, ObjectInputStream ois) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller)
				throws IOException {
			Integer intReturn;
			int length = 0;
			length = unmarshaller.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = unmarshaller.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, DataOutputStream dos, ObjectOutputStream oos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller)
				throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		public void readKeysData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_IMDB_factMovies) {

				try {

					int length = 0;

					this.tconst = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_IMDB_factMovies) {

				try {

					int length = 0;

					this.tconst = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeKeysData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.tconst, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.tconst, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		/**
		 * Fill Values data by reading ObjectInputStream.
		 */
		public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
			try {

				int length = 0;

				this.primaryTitle = readString(dis, ois);

				this.runtimeMinutes = readString(dis, ois);

				this.genres = readString(dis, ois);

				this.IdDate = readInteger(dis, ois);

				this.runtimeMinutes_1 = readString(dis, ois);

				this.Revenue__Millions = readString(dis, ois);

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
			try {
				int length = 0;

				this.primaryTitle = readString(dis, objectIn);

				this.runtimeMinutes = readString(dis, objectIn);

				this.genres = readString(dis, objectIn);

				this.IdDate = readInteger(dis, objectIn);

				this.runtimeMinutes_1 = readString(dis, objectIn);

				this.Revenue__Millions = readString(dis, objectIn);

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		/**
		 * Return a byte array which represents Values data.
		 */
		public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
			try {

				writeString(this.primaryTitle, dos, oos);

				writeString(this.runtimeMinutes, dos, oos);

				writeString(this.genres, dos, oos);

				writeInteger(this.IdDate, dos, oos);

				writeString(this.runtimeMinutes_1, dos, oos);

				writeString(this.Revenue__Millions, dos, oos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut) {
			try {

				writeString(this.primaryTitle, dos, objectOut);

				writeString(this.runtimeMinutes, dos, objectOut);

				writeString(this.genres, dos, objectOut);

				writeInteger(this.IdDate, dos, objectOut);

				writeString(this.runtimeMinutes_1, dos, objectOut);

				writeString(this.Revenue__Millions, dos, objectOut);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		public boolean supportMarshaller() {
			return true;
		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("tconst=" + tconst);
			sb.append(",primaryTitle=" + primaryTitle);
			sb.append(",runtimeMinutes=" + runtimeMinutes);
			sb.append(",genres=" + genres);
			sb.append(",IdDate=" + String.valueOf(IdDate));
			sb.append(",runtimeMinutes_1=" + runtimeMinutes_1);
			sb.append(",Revenue__Millions=" + Revenue__Millions);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(MoviesStruct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.tconst, other.tconst);
			if (returnValue != 0) {
				return returnValue;
			}

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class row2Struct implements routines.system.IPersistableRow<row2Struct> {
		final static byte[] commonByteArrayLock_IMDB_factMovies = new byte[0];
		static byte[] commonByteArray_IMDB_factMovies = new byte[0];

		public String tconst;

		public String getTconst() {
			return this.tconst;
		}

		public String titleType;

		public String getTitleType() {
			return this.titleType;
		}

		public String primaryTitle;

		public String getPrimaryTitle() {
			return this.primaryTitle;
		}

		public String originalTitle;

		public String getOriginalTitle() {
			return this.originalTitle;
		}

		public Integer isAdult;

		public Integer getIsAdult() {
			return this.isAdult;
		}

		public Integer startYear;

		public Integer getStartYear() {
			return this.startYear;
		}

		public String endYear;

		public String getEndYear() {
			return this.endYear;
		}

		public String runtimeMinutes;

		public String getRuntimeMinutes() {
			return this.runtimeMinutes;
		}

		public String genres;

		public String getGenres() {
			return this.genres;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_IMDB_factMovies.length) {
					if (length < 1024 && commonByteArray_IMDB_factMovies.length == 0) {
						commonByteArray_IMDB_factMovies = new byte[1024];
					} else {
						commonByteArray_IMDB_factMovies = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_IMDB_factMovies, 0, length);
				strReturn = new String(commonByteArray_IMDB_factMovies, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_IMDB_factMovies.length) {
					if (length < 1024 && commonByteArray_IMDB_factMovies.length == 0) {
						commonByteArray_IMDB_factMovies = new byte[1024];
					} else {
						commonByteArray_IMDB_factMovies = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_IMDB_factMovies, 0, length);
				strReturn = new String(commonByteArray_IMDB_factMovies, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_IMDB_factMovies) {

				try {

					int length = 0;

					this.tconst = readString(dis);

					this.titleType = readString(dis);

					this.primaryTitle = readString(dis);

					this.originalTitle = readString(dis);

					this.isAdult = readInteger(dis);

					this.startYear = readInteger(dis);

					this.endYear = readString(dis);

					this.runtimeMinutes = readString(dis);

					this.genres = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_IMDB_factMovies) {

				try {

					int length = 0;

					this.tconst = readString(dis);

					this.titleType = readString(dis);

					this.primaryTitle = readString(dis);

					this.originalTitle = readString(dis);

					this.isAdult = readInteger(dis);

					this.startYear = readInteger(dis);

					this.endYear = readString(dis);

					this.runtimeMinutes = readString(dis);

					this.genres = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.tconst, dos);

				// String

				writeString(this.titleType, dos);

				// String

				writeString(this.primaryTitle, dos);

				// String

				writeString(this.originalTitle, dos);

				// Integer

				writeInteger(this.isAdult, dos);

				// Integer

				writeInteger(this.startYear, dos);

				// String

				writeString(this.endYear, dos);

				// String

				writeString(this.runtimeMinutes, dos);

				// String

				writeString(this.genres, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.tconst, dos);

				// String

				writeString(this.titleType, dos);

				// String

				writeString(this.primaryTitle, dos);

				// String

				writeString(this.originalTitle, dos);

				// Integer

				writeInteger(this.isAdult, dos);

				// Integer

				writeInteger(this.startYear, dos);

				// String

				writeString(this.endYear, dos);

				// String

				writeString(this.runtimeMinutes, dos);

				// String

				writeString(this.genres, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("tconst=" + tconst);
			sb.append(",titleType=" + titleType);
			sb.append(",primaryTitle=" + primaryTitle);
			sb.append(",originalTitle=" + originalTitle);
			sb.append(",isAdult=" + String.valueOf(isAdult));
			sb.append(",startYear=" + String.valueOf(startYear));
			sb.append(",endYear=" + endYear);
			sb.append(",runtimeMinutes=" + runtimeMinutes);
			sb.append(",genres=" + genres);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row2Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class after_tFileInputDelimited_2Struct
			implements routines.system.IPersistableRow<after_tFileInputDelimited_2Struct> {
		final static byte[] commonByteArrayLock_IMDB_factMovies = new byte[0];
		static byte[] commonByteArray_IMDB_factMovies = new byte[0];

		public String tconst;

		public String getTconst() {
			return this.tconst;
		}

		public String titleType;

		public String getTitleType() {
			return this.titleType;
		}

		public String primaryTitle;

		public String getPrimaryTitle() {
			return this.primaryTitle;
		}

		public String originalTitle;

		public String getOriginalTitle() {
			return this.originalTitle;
		}

		public Integer isAdult;

		public Integer getIsAdult() {
			return this.isAdult;
		}

		public Integer startYear;

		public Integer getStartYear() {
			return this.startYear;
		}

		public String endYear;

		public String getEndYear() {
			return this.endYear;
		}

		public String runtimeMinutes;

		public String getRuntimeMinutes() {
			return this.runtimeMinutes;
		}

		public String genres;

		public String getGenres() {
			return this.genres;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_IMDB_factMovies.length) {
					if (length < 1024 && commonByteArray_IMDB_factMovies.length == 0) {
						commonByteArray_IMDB_factMovies = new byte[1024];
					} else {
						commonByteArray_IMDB_factMovies = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_IMDB_factMovies, 0, length);
				strReturn = new String(commonByteArray_IMDB_factMovies, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_IMDB_factMovies.length) {
					if (length < 1024 && commonByteArray_IMDB_factMovies.length == 0) {
						commonByteArray_IMDB_factMovies = new byte[1024];
					} else {
						commonByteArray_IMDB_factMovies = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_IMDB_factMovies, 0, length);
				strReturn = new String(commonByteArray_IMDB_factMovies, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_IMDB_factMovies) {

				try {

					int length = 0;

					this.tconst = readString(dis);

					this.titleType = readString(dis);

					this.primaryTitle = readString(dis);

					this.originalTitle = readString(dis);

					this.isAdult = readInteger(dis);

					this.startYear = readInteger(dis);

					this.endYear = readString(dis);

					this.runtimeMinutes = readString(dis);

					this.genres = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_IMDB_factMovies) {

				try {

					int length = 0;

					this.tconst = readString(dis);

					this.titleType = readString(dis);

					this.primaryTitle = readString(dis);

					this.originalTitle = readString(dis);

					this.isAdult = readInteger(dis);

					this.startYear = readInteger(dis);

					this.endYear = readString(dis);

					this.runtimeMinutes = readString(dis);

					this.genres = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.tconst, dos);

				// String

				writeString(this.titleType, dos);

				// String

				writeString(this.primaryTitle, dos);

				// String

				writeString(this.originalTitle, dos);

				// Integer

				writeInteger(this.isAdult, dos);

				// Integer

				writeInteger(this.startYear, dos);

				// String

				writeString(this.endYear, dos);

				// String

				writeString(this.runtimeMinutes, dos);

				// String

				writeString(this.genres, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.tconst, dos);

				// String

				writeString(this.titleType, dos);

				// String

				writeString(this.primaryTitle, dos);

				// String

				writeString(this.originalTitle, dos);

				// Integer

				writeInteger(this.isAdult, dos);

				// Integer

				writeInteger(this.startYear, dos);

				// String

				writeString(this.endYear, dos);

				// String

				writeString(this.runtimeMinutes, dos);

				// String

				writeString(this.genres, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("tconst=" + tconst);
			sb.append(",titleType=" + titleType);
			sb.append(",primaryTitle=" + primaryTitle);
			sb.append(",originalTitle=" + originalTitle);
			sb.append(",isAdult=" + String.valueOf(isAdult));
			sb.append(",startYear=" + String.valueOf(startYear));
			sb.append(",endYear=" + endYear);
			sb.append(",runtimeMinutes=" + runtimeMinutes);
			sb.append(",genres=" + genres);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(after_tFileInputDelimited_2Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tFileInputDelimited_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tFileInputDelimited_2_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				tFileInputDelimited_4Process(globalMap);

				row2Struct row2 = new row2Struct();
				MoviesStruct Movies = new MoviesStruct();

				/**
				 * [tAdvancedHash_Movies begin ] start
				 */

				ok_Hash.put("tAdvancedHash_Movies", false);
				start_Hash.put("tAdvancedHash_Movies", System.currentTimeMillis());

				currentComponent = "tAdvancedHash_Movies";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "Movies");
				}

				int tos_count_tAdvancedHash_Movies = 0;

				// connection name:Movies
				// source node:tMap_2 - inputs:(row2,row4) outputs:(Movies,Movies) | target
				// node:tAdvancedHash_Movies - inputs:(Movies) outputs:()
				// linked node: tMap_5 - inputs:(actors,Movies)
				// outputs:(actor_movie,actor_movie)

				org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_Movies = org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.ALL_MATCHES;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<MoviesStruct> tHash_Lookup_Movies = org.talend.designer.components.lookup.memory.AdvancedMemoryLookup
						.<MoviesStruct>getLookup(matchingModeEnum_Movies);

				globalMap.put("tHash_Lookup_Movies", tHash_Lookup_Movies);

				/**
				 * [tAdvancedHash_Movies begin ] stop
				 */

				/**
				 * [tMap_2 begin ] start
				 */

				ok_Hash.put("tMap_2", false);
				start_Hash.put("tMap_2", System.currentTimeMillis());

				currentComponent = "tMap_2";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row2");
				}

				int tos_count_tMap_2 = 0;

// ###############################
// # Lookup's keys initialization

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct> tHash_Lookup_row4 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct>) ((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct>) globalMap
						.get("tHash_Lookup_row4"));

				row4Struct row4HashKey = new row4Struct();
				row4Struct row4Default = new row4Struct();
// ###############################        

// ###############################
// # Vars initialization
				class Var__tMap_2__Struct {
				}
				Var__tMap_2__Struct Var__tMap_2 = new Var__tMap_2__Struct();
// ###############################

// ###############################
// # Outputs initialization
				MoviesStruct Movies_tmp = new MoviesStruct();
// ###############################

				/**
				 * [tMap_2 begin ] stop
				 */

				/**
				 * [tFileInputDelimited_2 begin ] start
				 */

				ok_Hash.put("tFileInputDelimited_2", false);
				start_Hash.put("tFileInputDelimited_2", System.currentTimeMillis());

				currentComponent = "tFileInputDelimited_2";

				int tos_count_tFileInputDelimited_2 = 0;

				final routines.system.RowState rowstate_tFileInputDelimited_2 = new routines.system.RowState();

				int nb_line_tFileInputDelimited_2 = 0;
				org.talend.fileprocess.FileInputDelimited fid_tFileInputDelimited_2 = null;
				int limit_tFileInputDelimited_2 = 500000;
				try {

					Object filename_tFileInputDelimited_2 = "C:/Users/ZMERLI/Downloads/imdb dataset/title.basics.tsv/title.basics.tsv";
					if (filename_tFileInputDelimited_2 instanceof java.io.InputStream) {

						int footer_value_tFileInputDelimited_2 = 0, random_value_tFileInputDelimited_2 = -1;
						if (footer_value_tFileInputDelimited_2 > 0 || random_value_tFileInputDelimited_2 > 0) {
							throw new java.lang.Exception(
									"When the input source is a stream,footer and random shouldn't be bigger than 0.");
						}

					}
					try {
						fid_tFileInputDelimited_2 = new org.talend.fileprocess.FileInputDelimited(
								"C:/Users/ZMERLI/Downloads/imdb dataset/title.basics.tsv/title.basics.tsv", "UTF-8",
								"\t", "\n", false, 1, 0, limit_tFileInputDelimited_2, -1, false);
					} catch (java.lang.Exception e) {
						globalMap.put("tFileInputDelimited_2_ERROR_MESSAGE", e.getMessage());

						System.err.println(e.getMessage());

					}

					while (fid_tFileInputDelimited_2 != null && fid_tFileInputDelimited_2.nextRecord()) {
						rowstate_tFileInputDelimited_2.reset();

						row2 = null;

						boolean whetherReject_tFileInputDelimited_2 = false;
						row2 = new row2Struct();
						try {

							int columnIndexWithD_tFileInputDelimited_2 = 0;

							String temp = "";

							columnIndexWithD_tFileInputDelimited_2 = 0;

							row2.tconst = fid_tFileInputDelimited_2.get(columnIndexWithD_tFileInputDelimited_2);

							columnIndexWithD_tFileInputDelimited_2 = 1;

							row2.titleType = fid_tFileInputDelimited_2.get(columnIndexWithD_tFileInputDelimited_2);

							columnIndexWithD_tFileInputDelimited_2 = 2;

							row2.primaryTitle = fid_tFileInputDelimited_2.get(columnIndexWithD_tFileInputDelimited_2);

							columnIndexWithD_tFileInputDelimited_2 = 3;

							row2.originalTitle = fid_tFileInputDelimited_2.get(columnIndexWithD_tFileInputDelimited_2);

							columnIndexWithD_tFileInputDelimited_2 = 4;

							temp = fid_tFileInputDelimited_2.get(columnIndexWithD_tFileInputDelimited_2);
							if (temp.length() > 0) {

								try {

									row2.isAdult = ParserUtils.parseTo_Integer(temp);

								} catch (java.lang.Exception ex_tFileInputDelimited_2) {
									globalMap.put("tFileInputDelimited_2_ERROR_MESSAGE",
											ex_tFileInputDelimited_2.getMessage());
									rowstate_tFileInputDelimited_2.setException(new RuntimeException(String.format(
											"Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
											"isAdult", "row2", temp, ex_tFileInputDelimited_2),
											ex_tFileInputDelimited_2));
								}

							} else {

								row2.isAdult = null;

							}

							columnIndexWithD_tFileInputDelimited_2 = 5;

							temp = fid_tFileInputDelimited_2.get(columnIndexWithD_tFileInputDelimited_2);
							if (temp.length() > 0) {

								try {

									row2.startYear = ParserUtils.parseTo_Integer(temp);

								} catch (java.lang.Exception ex_tFileInputDelimited_2) {
									globalMap.put("tFileInputDelimited_2_ERROR_MESSAGE",
											ex_tFileInputDelimited_2.getMessage());
									rowstate_tFileInputDelimited_2.setException(new RuntimeException(String.format(
											"Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
											"startYear", "row2", temp, ex_tFileInputDelimited_2),
											ex_tFileInputDelimited_2));
								}

							} else {

								row2.startYear = null;

							}

							columnIndexWithD_tFileInputDelimited_2 = 6;

							row2.endYear = fid_tFileInputDelimited_2.get(columnIndexWithD_tFileInputDelimited_2);

							columnIndexWithD_tFileInputDelimited_2 = 7;

							row2.runtimeMinutes = fid_tFileInputDelimited_2.get(columnIndexWithD_tFileInputDelimited_2);

							columnIndexWithD_tFileInputDelimited_2 = 8;

							row2.genres = fid_tFileInputDelimited_2.get(columnIndexWithD_tFileInputDelimited_2);

							if (rowstate_tFileInputDelimited_2.getException() != null) {
								throw rowstate_tFileInputDelimited_2.getException();
							}

						} catch (java.lang.Exception e) {
							globalMap.put("tFileInputDelimited_2_ERROR_MESSAGE", e.getMessage());
							whetherReject_tFileInputDelimited_2 = true;

							System.err.println(e.getMessage());
							row2 = null;

						}

						/**
						 * [tFileInputDelimited_2 begin ] stop
						 */

						/**
						 * [tFileInputDelimited_2 main ] start
						 */

						currentComponent = "tFileInputDelimited_2";

						tos_count_tFileInputDelimited_2++;

						/**
						 * [tFileInputDelimited_2 main ] stop
						 */

						/**
						 * [tFileInputDelimited_2 process_data_begin ] start
						 */

						currentComponent = "tFileInputDelimited_2";

						/**
						 * [tFileInputDelimited_2 process_data_begin ] stop
						 */
// Start of branch "row2"
						if (row2 != null) {

							/**
							 * [tMap_2 main ] start
							 */

							currentComponent = "tMap_2";

							if (execStat) {
								runStat.updateStatOnConnection(iterateId, 1, 1

										, "row2"

								);
							}

							boolean hasCasePrimitiveKeyWithNull_tMap_2 = false;

							// ###############################
							// # Input tables (lookups)
							boolean rejectedInnerJoin_tMap_2 = false;
							boolean mainRowRejected_tMap_2 = false;

							if (

							(

							row2.titleType.contains("movie") && !row2.startYear.equals("\\N")

							)

							) { // G_TM_M_280

								// CALL close main tMap filter for table 'row2'

								///////////////////////////////////////////////
								// Starting Lookup Table "row4"
								///////////////////////////////////////////////

								boolean forceLooprow4 = false;

								row4Struct row4ObjectFromLookup = null;

								if (!rejectedInnerJoin_tMap_2) { // G_TM_M_020

									hasCasePrimitiveKeyWithNull_tMap_2 = false;

									row4HashKey.Title = row2.primaryTitle;

									row4HashKey.hashCodeDirty = true;

									tHash_Lookup_row4.lookup(row4HashKey);

									if (!tHash_Lookup_row4.hasNext()) { // G_TM_M_090

										rejectedInnerJoin_tMap_2 = true;

										forceLooprow4 = true;

									} // G_TM_M_090

								} // G_TM_M_020

								else { // G 20 - G 21
									forceLooprow4 = true;
								} // G 21

								row4Struct row4 = null;

								while ((tHash_Lookup_row4 != null && tHash_Lookup_row4.hasNext()) || forceLooprow4) { // G_TM_M_043

									// CALL close loop of lookup 'row4'

									row4Struct fromLookup_row4 = null;
									row4 = row4Default;

									if (!forceLooprow4) { // G 46

										fromLookup_row4 = tHash_Lookup_row4.next();

										if (fromLookup_row4 != null) {
											row4 = fromLookup_row4;
										}

									} // G 46

									forceLooprow4 = false;

									// ###############################
									{ // start of Var scope

										// ###############################
										// # Vars tables

										Var__tMap_2__Struct Var = Var__tMap_2;// ###############################
										// ###############################
										// # Output tables

										Movies = null;

										if (!rejectedInnerJoin_tMap_2) {

// # Output table : 'Movies'
											Movies_tmp.tconst = row2.tconst;
											Movies_tmp.primaryTitle = row2.primaryTitle;
											Movies_tmp.runtimeMinutes = row2.runtimeMinutes;
											Movies_tmp.genres = row2.genres;
											Movies_tmp.IdDate = row2.startYear;
											Movies_tmp.runtimeMinutes_1 = row2.runtimeMinutes;
											Movies_tmp.Revenue__Millions = row4.Revenue__Millions;
											Movies = Movies_tmp;
										} // closing inner join bracket (2)
// ###############################

									} // end of Var scope

									rejectedInnerJoin_tMap_2 = false;

									tos_count_tMap_2++;

									/**
									 * [tMap_2 main ] stop
									 */

									/**
									 * [tMap_2 process_data_begin ] start
									 */

									currentComponent = "tMap_2";

									/**
									 * [tMap_2 process_data_begin ] stop
									 */
// Start of branch "Movies"
									if (Movies != null) {

										/**
										 * [tAdvancedHash_Movies main ] start
										 */

										currentComponent = "tAdvancedHash_Movies";

										if (execStat) {
											runStat.updateStatOnConnection(iterateId, 1, 1

													, "Movies"

											);
										}

										MoviesStruct Movies_HashRow = new MoviesStruct();

										Movies_HashRow.tconst = Movies.tconst;

										Movies_HashRow.primaryTitle = Movies.primaryTitle;

										Movies_HashRow.runtimeMinutes = Movies.runtimeMinutes;

										Movies_HashRow.genres = Movies.genres;

										Movies_HashRow.IdDate = Movies.IdDate;

										Movies_HashRow.runtimeMinutes_1 = Movies.runtimeMinutes_1;

										Movies_HashRow.Revenue__Millions = Movies.Revenue__Millions;

										tHash_Lookup_Movies.put(Movies_HashRow);

										tos_count_tAdvancedHash_Movies++;

										/**
										 * [tAdvancedHash_Movies main ] stop
										 */

										/**
										 * [tAdvancedHash_Movies process_data_begin ] start
										 */

										currentComponent = "tAdvancedHash_Movies";

										/**
										 * [tAdvancedHash_Movies process_data_begin ] stop
										 */

										/**
										 * [tAdvancedHash_Movies process_data_end ] start
										 */

										currentComponent = "tAdvancedHash_Movies";

										/**
										 * [tAdvancedHash_Movies process_data_end ] stop
										 */

									} // End of branch "Movies"

								} // close loop of lookup 'row4' // G_TM_M_043

							} // G_TM_M_280 close main tMap filter for table 'row2'

							/**
							 * [tMap_2 process_data_end ] start
							 */

							currentComponent = "tMap_2";

							/**
							 * [tMap_2 process_data_end ] stop
							 */

						} // End of branch "row2"

						/**
						 * [tFileInputDelimited_2 process_data_end ] start
						 */

						currentComponent = "tFileInputDelimited_2";

						/**
						 * [tFileInputDelimited_2 process_data_end ] stop
						 */

						/**
						 * [tFileInputDelimited_2 end ] start
						 */

						currentComponent = "tFileInputDelimited_2";

					}
				} finally {
					if (!((Object) ("C:/Users/ZMERLI/Downloads/imdb dataset/title.basics.tsv/title.basics.tsv") instanceof java.io.InputStream)) {
						if (fid_tFileInputDelimited_2 != null) {
							fid_tFileInputDelimited_2.close();
						}
					}
					if (fid_tFileInputDelimited_2 != null) {
						globalMap.put("tFileInputDelimited_2_NB_LINE", fid_tFileInputDelimited_2.getRowNumber());

					}
				}

				ok_Hash.put("tFileInputDelimited_2", true);
				end_Hash.put("tFileInputDelimited_2", System.currentTimeMillis());

				/**
				 * [tFileInputDelimited_2 end ] stop
				 */

				/**
				 * [tMap_2 end ] start
				 */

				currentComponent = "tMap_2";

// ###############################
// # Lookup hashes releasing
				if (tHash_Lookup_row4 != null) {
					tHash_Lookup_row4.endGet();
				}
				globalMap.remove("tHash_Lookup_row4");

// ###############################      

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row2");
				}

				ok_Hash.put("tMap_2", true);
				end_Hash.put("tMap_2", System.currentTimeMillis());

				/**
				 * [tMap_2 end ] stop
				 */

				/**
				 * [tAdvancedHash_Movies end ] start
				 */

				currentComponent = "tAdvancedHash_Movies";

				tHash_Lookup_Movies.endPut();

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "Movies");
				}

				ok_Hash.put("tAdvancedHash_Movies", true);
				end_Hash.put("tAdvancedHash_Movies", System.currentTimeMillis());

				/**
				 * [tAdvancedHash_Movies end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			// free memory for "tMap_2"
			globalMap.remove("tHash_Lookup_row4");

			try {

				/**
				 * [tFileInputDelimited_2 finally ] start
				 */

				currentComponent = "tFileInputDelimited_2";

				/**
				 * [tFileInputDelimited_2 finally ] stop
				 */

				/**
				 * [tMap_2 finally ] start
				 */

				currentComponent = "tMap_2";

				/**
				 * [tMap_2 finally ] stop
				 */

				/**
				 * [tAdvancedHash_Movies finally ] start
				 */

				currentComponent = "tAdvancedHash_Movies";

				/**
				 * [tAdvancedHash_Movies finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tFileInputDelimited_2_SUBPROCESS_STATE", 1);
	}

	public static class actor_movie_writerStruct
			implements routines.system.IPersistableComparableLookupRow<actor_movie_writerStruct> {
		final static byte[] commonByteArrayLock_IMDB_factMovies = new byte[0];
		static byte[] commonByteArray_IMDB_factMovies = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public String IdActor;

		public String getIdActor() {
			return this.IdActor;
		}

		public String IdMovie;

		public String getIdMovie() {
			return this.IdMovie;
		}

		public String IdWriter;

		public String getIdWriter() {
			return this.IdWriter;
		}

		public Integer IdDate;

		public Integer getIdDate() {
			return this.IdDate;
		}

		public String runtimeMinutes_1;

		public String getRuntimeMinutes_1() {
			return this.runtimeMinutes_1;
		}

		public String Revenue__Millions;

		public String getRevenue__Millions() {
			return this.Revenue__Millions;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + ((this.IdMovie == null) ? 0 : this.IdMovie.hashCode());

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final actor_movie_writerStruct other = (actor_movie_writerStruct) obj;

			if (this.IdMovie == null) {
				if (other.IdMovie != null)
					return false;

			} else if (!this.IdMovie.equals(other.IdMovie))

				return false;

			return true;
		}

		public void copyDataTo(actor_movie_writerStruct other) {

			other.IdActor = this.IdActor;
			other.IdMovie = this.IdMovie;
			other.IdWriter = this.IdWriter;
			other.IdDate = this.IdDate;
			other.runtimeMinutes_1 = this.runtimeMinutes_1;
			other.Revenue__Millions = this.Revenue__Millions;

		}

		public void copyKeysDataTo(actor_movie_writerStruct other) {

			other.IdMovie = this.IdMovie;

		}

		private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				byte[] byteArray = new byte[length];
				dis.read(byteArray);
				strReturn = new String(byteArray, utf8Charset);
			}
			return strReturn;
		}

		private String readString(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller)
				throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				byte[] byteArray = new byte[length];
				unmarshaller.read(byteArray);
				strReturn = new String(byteArray, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller)
				throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_IMDB_factMovies.length) {
					if (length < 1024 && commonByteArray_IMDB_factMovies.length == 0) {
						commonByteArray_IMDB_factMovies = new byte[1024];
					} else {
						commonByteArray_IMDB_factMovies = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_IMDB_factMovies, 0, length);
				strReturn = new String(commonByteArray_IMDB_factMovies, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_IMDB_factMovies.length) {
					if (length < 1024 && commonByteArray_IMDB_factMovies.length == 0) {
						commonByteArray_IMDB_factMovies = new byte[1024];
					} else {
						commonByteArray_IMDB_factMovies = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_IMDB_factMovies, 0, length);
				strReturn = new String(commonByteArray_IMDB_factMovies, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private Integer readInteger(DataInputStream dis, ObjectInputStream ois) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller)
				throws IOException {
			Integer intReturn;
			int length = 0;
			length = unmarshaller.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = unmarshaller.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, DataOutputStream dos, ObjectOutputStream oos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller)
				throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		public void readKeysData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_IMDB_factMovies) {

				try {

					int length = 0;

					this.IdMovie = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_IMDB_factMovies) {

				try {

					int length = 0;

					this.IdMovie = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeKeysData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.IdMovie, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.IdMovie, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		/**
		 * Fill Values data by reading ObjectInputStream.
		 */
		public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
			try {

				int length = 0;

				this.IdActor = readString(dis, ois);

				this.IdWriter = readString(dis, ois);

				this.IdDate = readInteger(dis, ois);

				this.runtimeMinutes_1 = readString(dis, ois);

				this.Revenue__Millions = readString(dis, ois);

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
			try {
				int length = 0;

				this.IdActor = readString(dis, objectIn);

				this.IdWriter = readString(dis, objectIn);

				this.IdDate = readInteger(dis, objectIn);

				this.runtimeMinutes_1 = readString(dis, objectIn);

				this.Revenue__Millions = readString(dis, objectIn);

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		/**
		 * Return a byte array which represents Values data.
		 */
		public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
			try {

				writeString(this.IdActor, dos, oos);

				writeString(this.IdWriter, dos, oos);

				writeInteger(this.IdDate, dos, oos);

				writeString(this.runtimeMinutes_1, dos, oos);

				writeString(this.Revenue__Millions, dos, oos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut) {
			try {

				writeString(this.IdActor, dos, objectOut);

				writeString(this.IdWriter, dos, objectOut);

				writeInteger(this.IdDate, dos, objectOut);

				writeString(this.runtimeMinutes_1, dos, objectOut);

				writeString(this.Revenue__Millions, dos, objectOut);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		public boolean supportMarshaller() {
			return true;
		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("IdActor=" + IdActor);
			sb.append(",IdMovie=" + IdMovie);
			sb.append(",IdWriter=" + IdWriter);
			sb.append(",IdDate=" + String.valueOf(IdDate));
			sb.append(",runtimeMinutes_1=" + runtimeMinutes_1);
			sb.append(",Revenue__Millions=" + Revenue__Millions);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(actor_movie_writerStruct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.IdMovie, other.IdMovie);
			if (returnValue != 0) {
				return returnValue;
			}

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class WritersStruct implements routines.system.IPersistableRow<WritersStruct> {
		final static byte[] commonByteArrayLock_IMDB_factMovies = new byte[0];
		static byte[] commonByteArray_IMDB_factMovies = new byte[0];

		public String nconst;

		public String getNconst() {
			return this.nconst;
		}

		public String primaryName;

		public String getPrimaryName() {
			return this.primaryName;
		}

		public String title;

		public String getTitle() {
			return this.title;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_IMDB_factMovies.length) {
					if (length < 1024 && commonByteArray_IMDB_factMovies.length == 0) {
						commonByteArray_IMDB_factMovies = new byte[1024];
					} else {
						commonByteArray_IMDB_factMovies = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_IMDB_factMovies, 0, length);
				strReturn = new String(commonByteArray_IMDB_factMovies, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_IMDB_factMovies.length) {
					if (length < 1024 && commonByteArray_IMDB_factMovies.length == 0) {
						commonByteArray_IMDB_factMovies = new byte[1024];
					} else {
						commonByteArray_IMDB_factMovies = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_IMDB_factMovies, 0, length);
				strReturn = new String(commonByteArray_IMDB_factMovies, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_IMDB_factMovies) {

				try {

					int length = 0;

					this.nconst = readString(dis);

					this.primaryName = readString(dis);

					this.title = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_IMDB_factMovies) {

				try {

					int length = 0;

					this.nconst = readString(dis);

					this.primaryName = readString(dis);

					this.title = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.nconst, dos);

				// String

				writeString(this.primaryName, dos);

				// String

				writeString(this.title, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.nconst, dos);

				// String

				writeString(this.primaryName, dos);

				// String

				writeString(this.title, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("nconst=" + nconst);
			sb.append(",primaryName=" + primaryName);
			sb.append(",title=" + title);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(WritersStruct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class row3Struct implements routines.system.IPersistableRow<row3Struct> {
		final static byte[] commonByteArrayLock_IMDB_factMovies = new byte[0];
		static byte[] commonByteArray_IMDB_factMovies = new byte[0];

		public String nconst;

		public String getNconst() {
			return this.nconst;
		}

		public String primaryName;

		public String getPrimaryName() {
			return this.primaryName;
		}

		public Integer birthYear;

		public Integer getBirthYear() {
			return this.birthYear;
		}

		public String deathYear;

		public String getDeathYear() {
			return this.deathYear;
		}

		public String primaryProfession;

		public String getPrimaryProfession() {
			return this.primaryProfession;
		}

		public String knownForTitles;

		public String getKnownForTitles() {
			return this.knownForTitles;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_IMDB_factMovies.length) {
					if (length < 1024 && commonByteArray_IMDB_factMovies.length == 0) {
						commonByteArray_IMDB_factMovies = new byte[1024];
					} else {
						commonByteArray_IMDB_factMovies = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_IMDB_factMovies, 0, length);
				strReturn = new String(commonByteArray_IMDB_factMovies, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_IMDB_factMovies.length) {
					if (length < 1024 && commonByteArray_IMDB_factMovies.length == 0) {
						commonByteArray_IMDB_factMovies = new byte[1024];
					} else {
						commonByteArray_IMDB_factMovies = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_IMDB_factMovies, 0, length);
				strReturn = new String(commonByteArray_IMDB_factMovies, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_IMDB_factMovies) {

				try {

					int length = 0;

					this.nconst = readString(dis);

					this.primaryName = readString(dis);

					this.birthYear = readInteger(dis);

					this.deathYear = readString(dis);

					this.primaryProfession = readString(dis);

					this.knownForTitles = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_IMDB_factMovies) {

				try {

					int length = 0;

					this.nconst = readString(dis);

					this.primaryName = readString(dis);

					this.birthYear = readInteger(dis);

					this.deathYear = readString(dis);

					this.primaryProfession = readString(dis);

					this.knownForTitles = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.nconst, dos);

				// String

				writeString(this.primaryName, dos);

				// Integer

				writeInteger(this.birthYear, dos);

				// String

				writeString(this.deathYear, dos);

				// String

				writeString(this.primaryProfession, dos);

				// String

				writeString(this.knownForTitles, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.nconst, dos);

				// String

				writeString(this.primaryName, dos);

				// Integer

				writeInteger(this.birthYear, dos);

				// String

				writeString(this.deathYear, dos);

				// String

				writeString(this.primaryProfession, dos);

				// String

				writeString(this.knownForTitles, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("nconst=" + nconst);
			sb.append(",primaryName=" + primaryName);
			sb.append(",birthYear=" + String.valueOf(birthYear));
			sb.append(",deathYear=" + deathYear);
			sb.append(",primaryProfession=" + primaryProfession);
			sb.append(",knownForTitles=" + knownForTitles);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row3Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class after_tFileInputDelimited_3Struct
			implements routines.system.IPersistableRow<after_tFileInputDelimited_3Struct> {
		final static byte[] commonByteArrayLock_IMDB_factMovies = new byte[0];
		static byte[] commonByteArray_IMDB_factMovies = new byte[0];

		public String nconst;

		public String getNconst() {
			return this.nconst;
		}

		public String primaryName;

		public String getPrimaryName() {
			return this.primaryName;
		}

		public Integer birthYear;

		public Integer getBirthYear() {
			return this.birthYear;
		}

		public String deathYear;

		public String getDeathYear() {
			return this.deathYear;
		}

		public String primaryProfession;

		public String getPrimaryProfession() {
			return this.primaryProfession;
		}

		public String knownForTitles;

		public String getKnownForTitles() {
			return this.knownForTitles;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_IMDB_factMovies.length) {
					if (length < 1024 && commonByteArray_IMDB_factMovies.length == 0) {
						commonByteArray_IMDB_factMovies = new byte[1024];
					} else {
						commonByteArray_IMDB_factMovies = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_IMDB_factMovies, 0, length);
				strReturn = new String(commonByteArray_IMDB_factMovies, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_IMDB_factMovies.length) {
					if (length < 1024 && commonByteArray_IMDB_factMovies.length == 0) {
						commonByteArray_IMDB_factMovies = new byte[1024];
					} else {
						commonByteArray_IMDB_factMovies = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_IMDB_factMovies, 0, length);
				strReturn = new String(commonByteArray_IMDB_factMovies, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_IMDB_factMovies) {

				try {

					int length = 0;

					this.nconst = readString(dis);

					this.primaryName = readString(dis);

					this.birthYear = readInteger(dis);

					this.deathYear = readString(dis);

					this.primaryProfession = readString(dis);

					this.knownForTitles = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_IMDB_factMovies) {

				try {

					int length = 0;

					this.nconst = readString(dis);

					this.primaryName = readString(dis);

					this.birthYear = readInteger(dis);

					this.deathYear = readString(dis);

					this.primaryProfession = readString(dis);

					this.knownForTitles = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.nconst, dos);

				// String

				writeString(this.primaryName, dos);

				// Integer

				writeInteger(this.birthYear, dos);

				// String

				writeString(this.deathYear, dos);

				// String

				writeString(this.primaryProfession, dos);

				// String

				writeString(this.knownForTitles, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.nconst, dos);

				// String

				writeString(this.primaryName, dos);

				// Integer

				writeInteger(this.birthYear, dos);

				// String

				writeString(this.deathYear, dos);

				// String

				writeString(this.primaryProfession, dos);

				// String

				writeString(this.knownForTitles, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("nconst=" + nconst);
			sb.append(",primaryName=" + primaryName);
			sb.append(",birthYear=" + String.valueOf(birthYear));
			sb.append(",deathYear=" + deathYear);
			sb.append(",primaryProfession=" + primaryProfession);
			sb.append(",knownForTitles=" + knownForTitles);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(after_tFileInputDelimited_3Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tFileInputDelimited_3Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tFileInputDelimited_3_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				tFileInputDelimited_1Process(globalMap);

				row3Struct row3 = new row3Struct();
				WritersStruct Writers = new WritersStruct();
				actor_movie_writerStruct actor_movie_writer = new actor_movie_writerStruct();

				/**
				 * [tAdvancedHash_actor_movie_writer begin ] start
				 */

				ok_Hash.put("tAdvancedHash_actor_movie_writer", false);
				start_Hash.put("tAdvancedHash_actor_movie_writer", System.currentTimeMillis());

				currentComponent = "tAdvancedHash_actor_movie_writer";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "actor_movie_writer");
				}

				int tos_count_tAdvancedHash_actor_movie_writer = 0;

				// connection name:actor_movie_writer
				// source node:tMap_7 - inputs:(actor_movie,Writers)
				// outputs:(actor_movie_writer,actor_movie_writer) | target
				// node:tAdvancedHash_actor_movie_writer - inputs:(actor_movie_writer)
				// outputs:()
				// linked node: tMap_4 - inputs:(actor_movie_writer,rating)
				// outputs:(actor_movie_date_rating)

				org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_actor_movie_writer = org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.ALL_MATCHES;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<actor_movie_writerStruct> tHash_Lookup_actor_movie_writer = org.talend.designer.components.lookup.memory.AdvancedMemoryLookup
						.<actor_movie_writerStruct>getLookup(matchingModeEnum_actor_movie_writer);

				globalMap.put("tHash_Lookup_actor_movie_writer", tHash_Lookup_actor_movie_writer);

				/**
				 * [tAdvancedHash_actor_movie_writer begin ] stop
				 */

				/**
				 * [tMap_7 begin ] start
				 */

				ok_Hash.put("tMap_7", false);
				start_Hash.put("tMap_7", System.currentTimeMillis());

				currentComponent = "tMap_7";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "Writers");
				}

				int tos_count_tMap_7 = 0;

// ###############################
// # Lookup's keys initialization

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<actor_movieStruct> tHash_Lookup_actor_movie = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<actor_movieStruct>) ((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<actor_movieStruct>) globalMap
						.get("tHash_Lookup_actor_movie"));

				actor_movieStruct actor_movieHashKey = new actor_movieStruct();
				actor_movieStruct actor_movieDefault = new actor_movieStruct();
// ###############################        

// ###############################
// # Vars initialization
				class Var__tMap_7__Struct {
				}
				Var__tMap_7__Struct Var__tMap_7 = new Var__tMap_7__Struct();
// ###############################

// ###############################
// # Outputs initialization
				actor_movie_writerStruct actor_movie_writer_tmp = new actor_movie_writerStruct();
// ###############################

				/**
				 * [tMap_7 begin ] stop
				 */

				/**
				 * [tMap_3 begin ] start
				 */

				ok_Hash.put("tMap_3", false);
				start_Hash.put("tMap_3", System.currentTimeMillis());

				currentComponent = "tMap_3";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row3");
				}

				int tos_count_tMap_3 = 0;

// ###############################
// # Lookup's keys initialization
// ###############################        

// ###############################
// # Vars initialization
				class Var__tMap_3__Struct {
					String title;
				}
				Var__tMap_3__Struct Var__tMap_3 = new Var__tMap_3__Struct();
// ###############################

// ###############################
// # Outputs initialization
				WritersStruct Writers_tmp = new WritersStruct();
// ###############################

				/**
				 * [tMap_3 begin ] stop
				 */

				/**
				 * [tFileInputDelimited_3 begin ] start
				 */

				ok_Hash.put("tFileInputDelimited_3", false);
				start_Hash.put("tFileInputDelimited_3", System.currentTimeMillis());

				currentComponent = "tFileInputDelimited_3";

				int tos_count_tFileInputDelimited_3 = 0;

				final routines.system.RowState rowstate_tFileInputDelimited_3 = new routines.system.RowState();

				int nb_line_tFileInputDelimited_3 = 0;
				org.talend.fileprocess.FileInputDelimited fid_tFileInputDelimited_3 = null;
				int limit_tFileInputDelimited_3 = 500000;
				try {

					Object filename_tFileInputDelimited_3 = "C:/Users/ZMERLI/Downloads/imdb dataset/name.basics.tsv/name.basics.tsv";
					if (filename_tFileInputDelimited_3 instanceof java.io.InputStream) {

						int footer_value_tFileInputDelimited_3 = 0, random_value_tFileInputDelimited_3 = -1;
						if (footer_value_tFileInputDelimited_3 > 0 || random_value_tFileInputDelimited_3 > 0) {
							throw new java.lang.Exception(
									"When the input source is a stream,footer and random shouldn't be bigger than 0.");
						}

					}
					try {
						fid_tFileInputDelimited_3 = new org.talend.fileprocess.FileInputDelimited(
								"C:/Users/ZMERLI/Downloads/imdb dataset/name.basics.tsv/name.basics.tsv", "US-ASCII",
								"\t", "\n", false, 1, 0, limit_tFileInputDelimited_3, -1, false);
					} catch (java.lang.Exception e) {
						globalMap.put("tFileInputDelimited_3_ERROR_MESSAGE", e.getMessage());

						System.err.println(e.getMessage());

					}

					while (fid_tFileInputDelimited_3 != null && fid_tFileInputDelimited_3.nextRecord()) {
						rowstate_tFileInputDelimited_3.reset();

						row3 = null;

						boolean whetherReject_tFileInputDelimited_3 = false;
						row3 = new row3Struct();
						try {

							int columnIndexWithD_tFileInputDelimited_3 = 0;

							String temp = "";

							columnIndexWithD_tFileInputDelimited_3 = 0;

							row3.nconst = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);

							columnIndexWithD_tFileInputDelimited_3 = 1;

							row3.primaryName = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);

							columnIndexWithD_tFileInputDelimited_3 = 2;

							temp = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);
							if (temp.length() > 0) {

								try {

									row3.birthYear = ParserUtils.parseTo_Integer(temp);

								} catch (java.lang.Exception ex_tFileInputDelimited_3) {
									globalMap.put("tFileInputDelimited_3_ERROR_MESSAGE",
											ex_tFileInputDelimited_3.getMessage());
									rowstate_tFileInputDelimited_3.setException(new RuntimeException(String.format(
											"Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
											"birthYear", "row3", temp, ex_tFileInputDelimited_3),
											ex_tFileInputDelimited_3));
								}

							} else {

								row3.birthYear = null;

							}

							columnIndexWithD_tFileInputDelimited_3 = 3;

							row3.deathYear = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);

							columnIndexWithD_tFileInputDelimited_3 = 4;

							row3.primaryProfession = fid_tFileInputDelimited_3
									.get(columnIndexWithD_tFileInputDelimited_3);

							columnIndexWithD_tFileInputDelimited_3 = 5;

							row3.knownForTitles = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);

							if (rowstate_tFileInputDelimited_3.getException() != null) {
								throw rowstate_tFileInputDelimited_3.getException();
							}

						} catch (java.lang.Exception e) {
							globalMap.put("tFileInputDelimited_3_ERROR_MESSAGE", e.getMessage());
							whetherReject_tFileInputDelimited_3 = true;

							System.err.println(e.getMessage());
							row3 = null;

						}

						/**
						 * [tFileInputDelimited_3 begin ] stop
						 */

						/**
						 * [tFileInputDelimited_3 main ] start
						 */

						currentComponent = "tFileInputDelimited_3";

						tos_count_tFileInputDelimited_3++;

						/**
						 * [tFileInputDelimited_3 main ] stop
						 */

						/**
						 * [tFileInputDelimited_3 process_data_begin ] start
						 */

						currentComponent = "tFileInputDelimited_3";

						/**
						 * [tFileInputDelimited_3 process_data_begin ] stop
						 */
// Start of branch "row3"
						if (row3 != null) {

							/**
							 * [tMap_3 main ] start
							 */

							currentComponent = "tMap_3";

							if (execStat) {
								runStat.updateStatOnConnection(iterateId, 1, 1

										, "row3"

								);
							}

							boolean hasCasePrimitiveKeyWithNull_tMap_3 = false;

							// ###############################
							// # Input tables (lookups)
							boolean rejectedInnerJoin_tMap_3 = false;
							boolean mainRowRejected_tMap_3 = false;

							if (

							(

							row3.primaryProfession.contains("writer") && !row3.birthYear.equals("\\N")

							)

							) { // G_TM_M_280

								// CALL close main tMap filter for table 'row3'
								// ###############################
								{ // start of Var scope

									// ###############################
									// # Vars tables

									Var__tMap_3__Struct Var = Var__tMap_3;
									Var.title = row3.knownForTitles.split(",")[0];// ###############################
									// ###############################
									// # Output tables

									Writers = null;

// # Output table : 'Writers'
									Writers_tmp.nconst = row3.nconst;
									Writers_tmp.primaryName = row3.primaryName;
									Writers_tmp.title = Var.title;
									Writers = Writers_tmp;
// ###############################

								} // end of Var scope

								rejectedInnerJoin_tMap_3 = false;

								tos_count_tMap_3++;

								/**
								 * [tMap_3 main ] stop
								 */

								/**
								 * [tMap_3 process_data_begin ] start
								 */

								currentComponent = "tMap_3";

								/**
								 * [tMap_3 process_data_begin ] stop
								 */
// Start of branch "Writers"
								if (Writers != null) {

									/**
									 * [tMap_7 main ] start
									 */

									currentComponent = "tMap_7";

									if (execStat) {
										runStat.updateStatOnConnection(iterateId, 1, 1

												, "Writers"

										);
									}

									boolean hasCasePrimitiveKeyWithNull_tMap_7 = false;

									// ###############################
									// # Input tables (lookups)
									boolean rejectedInnerJoin_tMap_7 = false;
									boolean mainRowRejected_tMap_7 = false;

									///////////////////////////////////////////////
									// Starting Lookup Table "actor_movie"
									///////////////////////////////////////////////

									boolean forceLoopactor_movie = false;

									actor_movieStruct actor_movieObjectFromLookup = null;

									if (!rejectedInnerJoin_tMap_7) { // G_TM_M_020

										hasCasePrimitiveKeyWithNull_tMap_7 = false;

										actor_movieHashKey.IdMovie = Writers.title;

										actor_movieHashKey.hashCodeDirty = true;

										tHash_Lookup_actor_movie.lookup(actor_movieHashKey);

										if (!tHash_Lookup_actor_movie.hasNext()) { // G_TM_M_090

											rejectedInnerJoin_tMap_7 = true;

											forceLoopactor_movie = true;

										} // G_TM_M_090

									} // G_TM_M_020

									else { // G 20 - G 21
										forceLoopactor_movie = true;
									} // G 21

									actor_movieStruct actor_movie = null;

									while ((tHash_Lookup_actor_movie != null && tHash_Lookup_actor_movie.hasNext())
											|| forceLoopactor_movie) { // G_TM_M_043

										// CALL close loop of lookup 'actor_movie'

										actor_movieStruct fromLookup_actor_movie = null;
										actor_movie = actor_movieDefault;

										if (!forceLoopactor_movie) { // G 46

											fromLookup_actor_movie = tHash_Lookup_actor_movie.next();

											if (fromLookup_actor_movie != null) {
												actor_movie = fromLookup_actor_movie;
											}

										} // G 46

										forceLoopactor_movie = false;

										// ###############################
										{ // start of Var scope

											// ###############################
											// # Vars tables

											Var__tMap_7__Struct Var = Var__tMap_7;// ###############################
											// ###############################
											// # Output tables

											actor_movie_writer = null;

											if (!rejectedInnerJoin_tMap_7) {

// # Output table : 'actor_movie_writer'
												actor_movie_writer_tmp.IdActor = actor_movie.IdActor;
												actor_movie_writer_tmp.IdMovie = actor_movie.IdMovie;
												actor_movie_writer_tmp.IdWriter = Writers.nconst;
												actor_movie_writer_tmp.IdDate = actor_movie.IdDate;
												actor_movie_writer_tmp.runtimeMinutes_1 = actor_movie.runtimeMinutes_1;
												actor_movie_writer_tmp.Revenue__Millions = actor_movie.Revenue__Millions;
												actor_movie_writer = actor_movie_writer_tmp;
											} // closing inner join bracket (2)
// ###############################

										} // end of Var scope

										rejectedInnerJoin_tMap_7 = false;

										tos_count_tMap_7++;

										/**
										 * [tMap_7 main ] stop
										 */

										/**
										 * [tMap_7 process_data_begin ] start
										 */

										currentComponent = "tMap_7";

										/**
										 * [tMap_7 process_data_begin ] stop
										 */
// Start of branch "actor_movie_writer"
										if (actor_movie_writer != null) {

											/**
											 * [tAdvancedHash_actor_movie_writer main ] start
											 */

											currentComponent = "tAdvancedHash_actor_movie_writer";

											if (execStat) {
												runStat.updateStatOnConnection(iterateId, 1, 1

														, "actor_movie_writer"

												);
											}

											actor_movie_writerStruct actor_movie_writer_HashRow = new actor_movie_writerStruct();

											actor_movie_writer_HashRow.IdActor = actor_movie_writer.IdActor;

											actor_movie_writer_HashRow.IdMovie = actor_movie_writer.IdMovie;

											actor_movie_writer_HashRow.IdWriter = actor_movie_writer.IdWriter;

											actor_movie_writer_HashRow.IdDate = actor_movie_writer.IdDate;

											actor_movie_writer_HashRow.runtimeMinutes_1 = actor_movie_writer.runtimeMinutes_1;

											actor_movie_writer_HashRow.Revenue__Millions = actor_movie_writer.Revenue__Millions;

											tHash_Lookup_actor_movie_writer.put(actor_movie_writer_HashRow);

											tos_count_tAdvancedHash_actor_movie_writer++;

											/**
											 * [tAdvancedHash_actor_movie_writer main ] stop
											 */

											/**
											 * [tAdvancedHash_actor_movie_writer process_data_begin ] start
											 */

											currentComponent = "tAdvancedHash_actor_movie_writer";

											/**
											 * [tAdvancedHash_actor_movie_writer process_data_begin ] stop
											 */

											/**
											 * [tAdvancedHash_actor_movie_writer process_data_end ] start
											 */

											currentComponent = "tAdvancedHash_actor_movie_writer";

											/**
											 * [tAdvancedHash_actor_movie_writer process_data_end ] stop
											 */

										} // End of branch "actor_movie_writer"

									} // close loop of lookup 'actor_movie' // G_TM_M_043

									/**
									 * [tMap_7 process_data_end ] start
									 */

									currentComponent = "tMap_7";

									/**
									 * [tMap_7 process_data_end ] stop
									 */

								} // End of branch "Writers"

							} // G_TM_M_280 close main tMap filter for table 'row3'

							/**
							 * [tMap_3 process_data_end ] start
							 */

							currentComponent = "tMap_3";

							/**
							 * [tMap_3 process_data_end ] stop
							 */

						} // End of branch "row3"

						/**
						 * [tFileInputDelimited_3 process_data_end ] start
						 */

						currentComponent = "tFileInputDelimited_3";

						/**
						 * [tFileInputDelimited_3 process_data_end ] stop
						 */

						/**
						 * [tFileInputDelimited_3 end ] start
						 */

						currentComponent = "tFileInputDelimited_3";

					}
				} finally {
					if (!((Object) ("C:/Users/ZMERLI/Downloads/imdb dataset/name.basics.tsv/name.basics.tsv") instanceof java.io.InputStream)) {
						if (fid_tFileInputDelimited_3 != null) {
							fid_tFileInputDelimited_3.close();
						}
					}
					if (fid_tFileInputDelimited_3 != null) {
						globalMap.put("tFileInputDelimited_3_NB_LINE", fid_tFileInputDelimited_3.getRowNumber());

					}
				}

				ok_Hash.put("tFileInputDelimited_3", true);
				end_Hash.put("tFileInputDelimited_3", System.currentTimeMillis());

				/**
				 * [tFileInputDelimited_3 end ] stop
				 */

				/**
				 * [tMap_3 end ] start
				 */

				currentComponent = "tMap_3";

// ###############################
// # Lookup hashes releasing
// ###############################      

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row3");
				}

				ok_Hash.put("tMap_3", true);
				end_Hash.put("tMap_3", System.currentTimeMillis());

				/**
				 * [tMap_3 end ] stop
				 */

				/**
				 * [tMap_7 end ] start
				 */

				currentComponent = "tMap_7";

// ###############################
// # Lookup hashes releasing
				if (tHash_Lookup_actor_movie != null) {
					tHash_Lookup_actor_movie.endGet();
				}
				globalMap.remove("tHash_Lookup_actor_movie");

// ###############################      

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "Writers");
				}

				ok_Hash.put("tMap_7", true);
				end_Hash.put("tMap_7", System.currentTimeMillis());

				/**
				 * [tMap_7 end ] stop
				 */

				/**
				 * [tAdvancedHash_actor_movie_writer end ] start
				 */

				currentComponent = "tAdvancedHash_actor_movie_writer";

				tHash_Lookup_actor_movie_writer.endPut();

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "actor_movie_writer");
				}

				ok_Hash.put("tAdvancedHash_actor_movie_writer", true);
				end_Hash.put("tAdvancedHash_actor_movie_writer", System.currentTimeMillis());

				/**
				 * [tAdvancedHash_actor_movie_writer end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			// free memory for "tMap_7"
			globalMap.remove("tHash_Lookup_actor_movie");

			try {

				/**
				 * [tFileInputDelimited_3 finally ] start
				 */

				currentComponent = "tFileInputDelimited_3";

				/**
				 * [tFileInputDelimited_3 finally ] stop
				 */

				/**
				 * [tMap_3 finally ] start
				 */

				currentComponent = "tMap_3";

				/**
				 * [tMap_3 finally ] stop
				 */

				/**
				 * [tMap_7 finally ] start
				 */

				currentComponent = "tMap_7";

				/**
				 * [tMap_7 finally ] stop
				 */

				/**
				 * [tAdvancedHash_actor_movie_writer finally ] start
				 */

				currentComponent = "tAdvancedHash_actor_movie_writer";

				/**
				 * [tAdvancedHash_actor_movie_writer finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tFileInputDelimited_3_SUBPROCESS_STATE", 1);
	}

	public static class row4Struct implements routines.system.IPersistableComparableLookupRow<row4Struct> {
		final static byte[] commonByteArrayLock_IMDB_factMovies = new byte[0];
		static byte[] commonByteArray_IMDB_factMovies = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public Integer Rank;

		public Integer getRank() {
			return this.Rank;
		}

		public String Title;

		public String getTitle() {
			return this.Title;
		}

		public String Description;

		public String getDescription() {
			return this.Description;
		}

		public String Director;

		public String getDirector() {
			return this.Director;
		}

		public String Actors;

		public String getActors() {
			return this.Actors;
		}

		public String Year;

		public String getYear() {
			return this.Year;
		}

		public Integer Runtime__Minutes;

		public Integer getRuntime__Minutes() {
			return this.Runtime__Minutes;
		}

		public Float Rating;

		public Float getRating() {
			return this.Rating;
		}

		public Float Votes;

		public Float getVotes() {
			return this.Votes;
		}

		public String Revenue__Millions;

		public String getRevenue__Millions() {
			return this.Revenue__Millions;
		}

		public String Metascore;

		public String getMetascore() {
			return this.Metascore;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + ((this.Title == null) ? 0 : this.Title.hashCode());

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final row4Struct other = (row4Struct) obj;

			if (this.Title == null) {
				if (other.Title != null)
					return false;

			} else if (!this.Title.equals(other.Title))

				return false;

			return true;
		}

		public void copyDataTo(row4Struct other) {

			other.Rank = this.Rank;
			other.Title = this.Title;
			other.Description = this.Description;
			other.Director = this.Director;
			other.Actors = this.Actors;
			other.Year = this.Year;
			other.Runtime__Minutes = this.Runtime__Minutes;
			other.Rating = this.Rating;
			other.Votes = this.Votes;
			other.Revenue__Millions = this.Revenue__Millions;
			other.Metascore = this.Metascore;

		}

		public void copyKeysDataTo(row4Struct other) {

			other.Title = this.Title;

		}

		private Integer readInteger(DataInputStream dis, ObjectInputStream ois) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller)
				throws IOException {
			Integer intReturn;
			int length = 0;
			length = unmarshaller.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = unmarshaller.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, DataOutputStream dos, ObjectOutputStream oos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller)
				throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_IMDB_factMovies.length) {
					if (length < 1024 && commonByteArray_IMDB_factMovies.length == 0) {
						commonByteArray_IMDB_factMovies = new byte[1024];
					} else {
						commonByteArray_IMDB_factMovies = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_IMDB_factMovies, 0, length);
				strReturn = new String(commonByteArray_IMDB_factMovies, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_IMDB_factMovies.length) {
					if (length < 1024 && commonByteArray_IMDB_factMovies.length == 0) {
						commonByteArray_IMDB_factMovies = new byte[1024];
					} else {
						commonByteArray_IMDB_factMovies = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_IMDB_factMovies, 0, length);
				strReturn = new String(commonByteArray_IMDB_factMovies, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				byte[] byteArray = new byte[length];
				dis.read(byteArray);
				strReturn = new String(byteArray, utf8Charset);
			}
			return strReturn;
		}

		private String readString(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller)
				throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				byte[] byteArray = new byte[length];
				unmarshaller.read(byteArray);
				strReturn = new String(byteArray, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller)
				throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		public void readKeysData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_IMDB_factMovies) {

				try {

					int length = 0;

					this.Title = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_IMDB_factMovies) {

				try {

					int length = 0;

					this.Title = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeKeysData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.Title, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.Title, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		/**
		 * Fill Values data by reading ObjectInputStream.
		 */
		public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
			try {

				int length = 0;

				this.Rank = readInteger(dis, ois);

				this.Description = readString(dis, ois);

				this.Director = readString(dis, ois);

				this.Actors = readString(dis, ois);

				this.Year = readString(dis, ois);

				this.Runtime__Minutes = readInteger(dis, ois);

				length = dis.readByte();
				if (length == -1) {
					this.Rating = null;
				} else {
					this.Rating = dis.readFloat();
				}

				length = dis.readByte();
				if (length == -1) {
					this.Votes = null;
				} else {
					this.Votes = dis.readFloat();
				}

				this.Revenue__Millions = readString(dis, ois);

				this.Metascore = readString(dis, ois);

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
			try {
				int length = 0;

				this.Rank = readInteger(dis, objectIn);

				this.Description = readString(dis, objectIn);

				this.Director = readString(dis, objectIn);

				this.Actors = readString(dis, objectIn);

				this.Year = readString(dis, objectIn);

				this.Runtime__Minutes = readInteger(dis, objectIn);

				length = objectIn.readByte();
				if (length == -1) {
					this.Rating = null;
				} else {
					this.Rating = objectIn.readFloat();
				}

				length = objectIn.readByte();
				if (length == -1) {
					this.Votes = null;
				} else {
					this.Votes = objectIn.readFloat();
				}

				this.Revenue__Millions = readString(dis, objectIn);

				this.Metascore = readString(dis, objectIn);

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		/**
		 * Return a byte array which represents Values data.
		 */
		public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
			try {

				writeInteger(this.Rank, dos, oos);

				writeString(this.Description, dos, oos);

				writeString(this.Director, dos, oos);

				writeString(this.Actors, dos, oos);

				writeString(this.Year, dos, oos);

				writeInteger(this.Runtime__Minutes, dos, oos);

				if (this.Rating == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.Rating);
				}

				if (this.Votes == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.Votes);
				}

				writeString(this.Revenue__Millions, dos, oos);

				writeString(this.Metascore, dos, oos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut) {
			try {

				writeInteger(this.Rank, dos, objectOut);

				writeString(this.Description, dos, objectOut);

				writeString(this.Director, dos, objectOut);

				writeString(this.Actors, dos, objectOut);

				writeString(this.Year, dos, objectOut);

				writeInteger(this.Runtime__Minutes, dos, objectOut);

				if (this.Rating == null) {
					objectOut.writeByte(-1);
				} else {
					objectOut.writeByte(0);
					objectOut.writeFloat(this.Rating);
				}

				if (this.Votes == null) {
					objectOut.writeByte(-1);
				} else {
					objectOut.writeByte(0);
					objectOut.writeFloat(this.Votes);
				}

				writeString(this.Revenue__Millions, dos, objectOut);

				writeString(this.Metascore, dos, objectOut);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		public boolean supportMarshaller() {
			return true;
		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("Rank=" + String.valueOf(Rank));
			sb.append(",Title=" + Title);
			sb.append(",Description=" + Description);
			sb.append(",Director=" + Director);
			sb.append(",Actors=" + Actors);
			sb.append(",Year=" + Year);
			sb.append(",Runtime__Minutes=" + String.valueOf(Runtime__Minutes));
			sb.append(",Rating=" + String.valueOf(Rating));
			sb.append(",Votes=" + String.valueOf(Votes));
			sb.append(",Revenue__Millions=" + Revenue__Millions);
			sb.append(",Metascore=" + Metascore);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row4Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.Title, other.Title);
			if (returnValue != 0) {
				return returnValue;
			}

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tFileInputDelimited_4Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tFileInputDelimited_4_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				row4Struct row4 = new row4Struct();

				/**
				 * [tAdvancedHash_row4 begin ] start
				 */

				ok_Hash.put("tAdvancedHash_row4", false);
				start_Hash.put("tAdvancedHash_row4", System.currentTimeMillis());

				currentComponent = "tAdvancedHash_row4";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row4");
				}

				int tos_count_tAdvancedHash_row4 = 0;

				// connection name:row4
				// source node:tFileInputDelimited_4 - inputs:(after_tFileInputDelimited_2)
				// outputs:(row4,row4) | target node:tAdvancedHash_row4 - inputs:(row4)
				// outputs:()
				// linked node: tMap_2 - inputs:(row2,row4) outputs:(Movies,Movies)

				org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row4 = org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.ALL_MATCHES;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct> tHash_Lookup_row4 = org.talend.designer.components.lookup.memory.AdvancedMemoryLookup
						.<row4Struct>getLookup(matchingModeEnum_row4);

				globalMap.put("tHash_Lookup_row4", tHash_Lookup_row4);

				/**
				 * [tAdvancedHash_row4 begin ] stop
				 */

				/**
				 * [tFileInputDelimited_4 begin ] start
				 */

				ok_Hash.put("tFileInputDelimited_4", false);
				start_Hash.put("tFileInputDelimited_4", System.currentTimeMillis());

				currentComponent = "tFileInputDelimited_4";

				int tos_count_tFileInputDelimited_4 = 0;

				final routines.system.RowState rowstate_tFileInputDelimited_4 = new routines.system.RowState();

				int nb_line_tFileInputDelimited_4 = 0;
				int footer_tFileInputDelimited_4 = 0;
				int totalLinetFileInputDelimited_4 = 0;
				int limittFileInputDelimited_4 = 500000;
				int lastLinetFileInputDelimited_4 = -1;

				char fieldSeparator_tFileInputDelimited_4[] = null;

				// support passing value (property: Field Separator) by 'context.fs' or
				// 'globalMap.get("fs")'.
				if (((String) ",").length() > 0) {
					fieldSeparator_tFileInputDelimited_4 = ((String) ",").toCharArray();
				} else {
					throw new IllegalArgumentException("Field Separator must be assigned a char.");
				}

				char rowSeparator_tFileInputDelimited_4[] = null;

				// support passing value (property: Row Separator) by 'context.rs' or
				// 'globalMap.get("rs")'.
				if (((String) "\n").length() > 0) {
					rowSeparator_tFileInputDelimited_4 = ((String) "\n").toCharArray();
				} else {
					throw new IllegalArgumentException("Row Separator must be assigned a char.");
				}

				Object filename_tFileInputDelimited_4 = /** Start field tFileInputDelimited_4:FILENAME */
						"C:/Users/ZMERLI/Downloads/revenu.source.csv"/** End field tFileInputDelimited_4:FILENAME */
				;
				com.talend.csv.CSVReader csvReadertFileInputDelimited_4 = null;

				try {

					String[] rowtFileInputDelimited_4 = null;
					int currentLinetFileInputDelimited_4 = 0;
					int outputLinetFileInputDelimited_4 = 0;
					try {// TD110 begin
						if (filename_tFileInputDelimited_4 instanceof java.io.InputStream) {

							int footer_value_tFileInputDelimited_4 = 0;
							if (footer_value_tFileInputDelimited_4 > 0) {
								throw new java.lang.Exception(
										"When the input source is a stream,footer shouldn't be bigger than 0.");
							}

							csvReadertFileInputDelimited_4 = new com.talend.csv.CSVReader(
									(java.io.InputStream) filename_tFileInputDelimited_4,
									fieldSeparator_tFileInputDelimited_4[0], "UTF-8");
						} else {
							csvReadertFileInputDelimited_4 = new com.talend.csv.CSVReader(
									String.valueOf(filename_tFileInputDelimited_4),
									fieldSeparator_tFileInputDelimited_4[0], "UTF-8");
						}

						csvReadertFileInputDelimited_4.setTrimWhitespace(false);
						if ((rowSeparator_tFileInputDelimited_4[0] != '\n')
								&& (rowSeparator_tFileInputDelimited_4[0] != '\r'))
							csvReadertFileInputDelimited_4.setLineEnd("" + rowSeparator_tFileInputDelimited_4[0]);

						csvReadertFileInputDelimited_4.setQuoteChar('\"');

						// ?????doesn't work for other escapeChar
						// the default escape mode is double escape
						csvReadertFileInputDelimited_4.setEscapeChar(csvReadertFileInputDelimited_4.getQuoteChar());

						if (footer_tFileInputDelimited_4 > 0) {
							for (totalLinetFileInputDelimited_4 = 0; totalLinetFileInputDelimited_4 < 1; totalLinetFileInputDelimited_4++) {
								csvReadertFileInputDelimited_4.readNext();
							}
							csvReadertFileInputDelimited_4.setSkipEmptyRecords(false);
							while (csvReadertFileInputDelimited_4.readNext()) {

								totalLinetFileInputDelimited_4++;

							}
							int lastLineTemptFileInputDelimited_4 = totalLinetFileInputDelimited_4
									- footer_tFileInputDelimited_4 < 0 ? 0
											: totalLinetFileInputDelimited_4 - footer_tFileInputDelimited_4;
							if (lastLinetFileInputDelimited_4 > 0) {
								lastLinetFileInputDelimited_4 = lastLinetFileInputDelimited_4 < lastLineTemptFileInputDelimited_4
										? lastLinetFileInputDelimited_4
										: lastLineTemptFileInputDelimited_4;
							} else {
								lastLinetFileInputDelimited_4 = lastLineTemptFileInputDelimited_4;
							}

							csvReadertFileInputDelimited_4.close();
							if (filename_tFileInputDelimited_4 instanceof java.io.InputStream) {
								csvReadertFileInputDelimited_4 = new com.talend.csv.CSVReader(
										(java.io.InputStream) filename_tFileInputDelimited_4,
										fieldSeparator_tFileInputDelimited_4[0], "UTF-8");
							} else {
								csvReadertFileInputDelimited_4 = new com.talend.csv.CSVReader(
										String.valueOf(filename_tFileInputDelimited_4),
										fieldSeparator_tFileInputDelimited_4[0], "UTF-8");
							}
							csvReadertFileInputDelimited_4.setTrimWhitespace(false);
							if ((rowSeparator_tFileInputDelimited_4[0] != '\n')
									&& (rowSeparator_tFileInputDelimited_4[0] != '\r'))
								csvReadertFileInputDelimited_4.setLineEnd("" + rowSeparator_tFileInputDelimited_4[0]);

							csvReadertFileInputDelimited_4.setQuoteChar('\"');

							// ?????doesn't work for other escapeChar
							// the default escape mode is double escape
							csvReadertFileInputDelimited_4.setEscapeChar(csvReadertFileInputDelimited_4.getQuoteChar());

						}

						if (limittFileInputDelimited_4 != 0) {
							for (currentLinetFileInputDelimited_4 = 0; currentLinetFileInputDelimited_4 < 1; currentLinetFileInputDelimited_4++) {
								csvReadertFileInputDelimited_4.readNext();
							}
						}
						csvReadertFileInputDelimited_4.setSkipEmptyRecords(false);

					} catch (java.lang.Exception e) {
						globalMap.put("tFileInputDelimited_4_ERROR_MESSAGE", e.getMessage());

						System.err.println(e.getMessage());

					} // TD110 end

					while (limittFileInputDelimited_4 != 0 && csvReadertFileInputDelimited_4 != null
							&& csvReadertFileInputDelimited_4.readNext()) {
						rowstate_tFileInputDelimited_4.reset();

						rowtFileInputDelimited_4 = csvReadertFileInputDelimited_4.getValues();

						currentLinetFileInputDelimited_4++;

						if (lastLinetFileInputDelimited_4 > -1
								&& currentLinetFileInputDelimited_4 > lastLinetFileInputDelimited_4) {
							break;
						}
						outputLinetFileInputDelimited_4++;
						if (limittFileInputDelimited_4 > 0
								&& outputLinetFileInputDelimited_4 > limittFileInputDelimited_4) {
							break;
						}

						row4 = null;

						row4 = null;

						boolean whetherReject_tFileInputDelimited_4 = false;
						row4 = new row4Struct();
						try {

							char fieldSeparator_tFileInputDelimited_4_ListType[] = null;
							// support passing value (property: Field Separator) by 'context.fs' or
							// 'globalMap.get("fs")'.
							if (((String) ",").length() > 0) {
								fieldSeparator_tFileInputDelimited_4_ListType = ((String) ",").toCharArray();
							} else {
								throw new IllegalArgumentException("Field Separator must be assigned a char.");
							}
							if (rowtFileInputDelimited_4.length == 1 && ("\015").equals(rowtFileInputDelimited_4[0])) {// empty
																														// line
																														// when
																														// row
																														// separator
																														// is
																														// '\n'

								row4.Rank = null;

								row4.Title = null;

								row4.Description = null;

								row4.Director = null;

								row4.Actors = null;

								row4.Year = null;

								row4.Runtime__Minutes = null;

								row4.Rating = null;

								row4.Votes = null;

								row4.Revenue__Millions = null;

								row4.Metascore = null;

							} else {

								int columnIndexWithD_tFileInputDelimited_4 = 0; // Column Index

								columnIndexWithD_tFileInputDelimited_4 = 0;

								if (columnIndexWithD_tFileInputDelimited_4 < rowtFileInputDelimited_4.length) {

									if (rowtFileInputDelimited_4[columnIndexWithD_tFileInputDelimited_4].length() > 0) {
										try {

											row4.Rank = ParserUtils.parseTo_Integer(
													rowtFileInputDelimited_4[columnIndexWithD_tFileInputDelimited_4]);

										} catch (java.lang.Exception ex_tFileInputDelimited_4) {
											globalMap.put("tFileInputDelimited_4_ERROR_MESSAGE",
													ex_tFileInputDelimited_4.getMessage());
											rowstate_tFileInputDelimited_4.setException(new RuntimeException(String
													.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
															"Rank", "row4",
															rowtFileInputDelimited_4[columnIndexWithD_tFileInputDelimited_4],
															ex_tFileInputDelimited_4),
													ex_tFileInputDelimited_4));
										}
									} else {

										row4.Rank = null;

									}

								} else {

									row4.Rank = null;

								}

								columnIndexWithD_tFileInputDelimited_4 = 1;

								if (columnIndexWithD_tFileInputDelimited_4 < rowtFileInputDelimited_4.length) {

									row4.Title = rowtFileInputDelimited_4[columnIndexWithD_tFileInputDelimited_4];

								} else {

									row4.Title = null;

								}

								columnIndexWithD_tFileInputDelimited_4 = 2;

								if (columnIndexWithD_tFileInputDelimited_4 < rowtFileInputDelimited_4.length) {

									row4.Description = rowtFileInputDelimited_4[columnIndexWithD_tFileInputDelimited_4];

								} else {

									row4.Description = null;

								}

								columnIndexWithD_tFileInputDelimited_4 = 3;

								if (columnIndexWithD_tFileInputDelimited_4 < rowtFileInputDelimited_4.length) {

									row4.Director = rowtFileInputDelimited_4[columnIndexWithD_tFileInputDelimited_4];

								} else {

									row4.Director = null;

								}

								columnIndexWithD_tFileInputDelimited_4 = 4;

								if (columnIndexWithD_tFileInputDelimited_4 < rowtFileInputDelimited_4.length) {

									row4.Actors = rowtFileInputDelimited_4[columnIndexWithD_tFileInputDelimited_4];

								} else {

									row4.Actors = null;

								}

								columnIndexWithD_tFileInputDelimited_4 = 5;

								if (columnIndexWithD_tFileInputDelimited_4 < rowtFileInputDelimited_4.length) {

									row4.Year = rowtFileInputDelimited_4[columnIndexWithD_tFileInputDelimited_4];

								} else {

									row4.Year = null;

								}

								columnIndexWithD_tFileInputDelimited_4 = 6;

								if (columnIndexWithD_tFileInputDelimited_4 < rowtFileInputDelimited_4.length) {

									if (rowtFileInputDelimited_4[columnIndexWithD_tFileInputDelimited_4].length() > 0) {
										try {

											row4.Runtime__Minutes = ParserUtils.parseTo_Integer(
													rowtFileInputDelimited_4[columnIndexWithD_tFileInputDelimited_4]);

										} catch (java.lang.Exception ex_tFileInputDelimited_4) {
											globalMap.put("tFileInputDelimited_4_ERROR_MESSAGE",
													ex_tFileInputDelimited_4.getMessage());
											rowstate_tFileInputDelimited_4.setException(new RuntimeException(String
													.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
															"Runtime__Minutes", "row4",
															rowtFileInputDelimited_4[columnIndexWithD_tFileInputDelimited_4],
															ex_tFileInputDelimited_4),
													ex_tFileInputDelimited_4));
										}
									} else {

										row4.Runtime__Minutes = null;

									}

								} else {

									row4.Runtime__Minutes = null;

								}

								columnIndexWithD_tFileInputDelimited_4 = 7;

								if (columnIndexWithD_tFileInputDelimited_4 < rowtFileInputDelimited_4.length) {

									if (rowtFileInputDelimited_4[columnIndexWithD_tFileInputDelimited_4].length() > 0) {
										try {

											row4.Rating = ParserUtils.parseTo_Float(
													rowtFileInputDelimited_4[columnIndexWithD_tFileInputDelimited_4]);

										} catch (java.lang.Exception ex_tFileInputDelimited_4) {
											globalMap.put("tFileInputDelimited_4_ERROR_MESSAGE",
													ex_tFileInputDelimited_4.getMessage());
											rowstate_tFileInputDelimited_4.setException(new RuntimeException(String
													.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
															"Rating", "row4",
															rowtFileInputDelimited_4[columnIndexWithD_tFileInputDelimited_4],
															ex_tFileInputDelimited_4),
													ex_tFileInputDelimited_4));
										}
									} else {

										row4.Rating = null;

									}

								} else {

									row4.Rating = null;

								}

								columnIndexWithD_tFileInputDelimited_4 = 8;

								if (columnIndexWithD_tFileInputDelimited_4 < rowtFileInputDelimited_4.length) {

									if (rowtFileInputDelimited_4[columnIndexWithD_tFileInputDelimited_4].length() > 0) {
										try {

											row4.Votes = ParserUtils.parseTo_Float(
													rowtFileInputDelimited_4[columnIndexWithD_tFileInputDelimited_4]);

										} catch (java.lang.Exception ex_tFileInputDelimited_4) {
											globalMap.put("tFileInputDelimited_4_ERROR_MESSAGE",
													ex_tFileInputDelimited_4.getMessage());
											rowstate_tFileInputDelimited_4.setException(new RuntimeException(String
													.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
															"Votes", "row4",
															rowtFileInputDelimited_4[columnIndexWithD_tFileInputDelimited_4],
															ex_tFileInputDelimited_4),
													ex_tFileInputDelimited_4));
										}
									} else {

										row4.Votes = null;

									}

								} else {

									row4.Votes = null;

								}

								columnIndexWithD_tFileInputDelimited_4 = 9;

								if (columnIndexWithD_tFileInputDelimited_4 < rowtFileInputDelimited_4.length) {

									row4.Revenue__Millions = rowtFileInputDelimited_4[columnIndexWithD_tFileInputDelimited_4];

								} else {

									row4.Revenue__Millions = null;

								}

								columnIndexWithD_tFileInputDelimited_4 = 10;

								if (columnIndexWithD_tFileInputDelimited_4 < rowtFileInputDelimited_4.length) {

									row4.Metascore = rowtFileInputDelimited_4[columnIndexWithD_tFileInputDelimited_4];

								} else {

									row4.Metascore = null;

								}

							}

							if (rowstate_tFileInputDelimited_4.getException() != null) {
								throw rowstate_tFileInputDelimited_4.getException();
							}

						} catch (java.lang.Exception e) {
							globalMap.put("tFileInputDelimited_4_ERROR_MESSAGE", e.getMessage());
							whetherReject_tFileInputDelimited_4 = true;

							System.err.println(e.getMessage());
							row4 = null;

							globalMap.put("tFileInputDelimited_4_ERROR_MESSAGE", e.getMessage());

						}

						/**
						 * [tFileInputDelimited_4 begin ] stop
						 */

						/**
						 * [tFileInputDelimited_4 main ] start
						 */

						currentComponent = "tFileInputDelimited_4";

						tos_count_tFileInputDelimited_4++;

						/**
						 * [tFileInputDelimited_4 main ] stop
						 */

						/**
						 * [tFileInputDelimited_4 process_data_begin ] start
						 */

						currentComponent = "tFileInputDelimited_4";

						/**
						 * [tFileInputDelimited_4 process_data_begin ] stop
						 */
// Start of branch "row4"
						if (row4 != null) {

							/**
							 * [tAdvancedHash_row4 main ] start
							 */

							currentComponent = "tAdvancedHash_row4";

							if (execStat) {
								runStat.updateStatOnConnection(iterateId, 1, 1

										, "row4"

								);
							}

							row4Struct row4_HashRow = new row4Struct();

							row4_HashRow.Rank = row4.Rank;

							row4_HashRow.Title = row4.Title;

							row4_HashRow.Description = row4.Description;

							row4_HashRow.Director = row4.Director;

							row4_HashRow.Actors = row4.Actors;

							row4_HashRow.Year = row4.Year;

							row4_HashRow.Runtime__Minutes = row4.Runtime__Minutes;

							row4_HashRow.Rating = row4.Rating;

							row4_HashRow.Votes = row4.Votes;

							row4_HashRow.Revenue__Millions = row4.Revenue__Millions;

							row4_HashRow.Metascore = row4.Metascore;

							tHash_Lookup_row4.put(row4_HashRow);

							tos_count_tAdvancedHash_row4++;

							/**
							 * [tAdvancedHash_row4 main ] stop
							 */

							/**
							 * [tAdvancedHash_row4 process_data_begin ] start
							 */

							currentComponent = "tAdvancedHash_row4";

							/**
							 * [tAdvancedHash_row4 process_data_begin ] stop
							 */

							/**
							 * [tAdvancedHash_row4 process_data_end ] start
							 */

							currentComponent = "tAdvancedHash_row4";

							/**
							 * [tAdvancedHash_row4 process_data_end ] stop
							 */

						} // End of branch "row4"

						/**
						 * [tFileInputDelimited_4 process_data_end ] start
						 */

						currentComponent = "tFileInputDelimited_4";

						/**
						 * [tFileInputDelimited_4 process_data_end ] stop
						 */

						/**
						 * [tFileInputDelimited_4 end ] start
						 */

						currentComponent = "tFileInputDelimited_4";

						nb_line_tFileInputDelimited_4++;
					}

				} finally {
					if (!(filename_tFileInputDelimited_4 instanceof java.io.InputStream)) {
						if (csvReadertFileInputDelimited_4 != null) {
							csvReadertFileInputDelimited_4.close();
						}
					}
					if (csvReadertFileInputDelimited_4 != null) {
						globalMap.put("tFileInputDelimited_4_NB_LINE", nb_line_tFileInputDelimited_4);
					}

				}

				ok_Hash.put("tFileInputDelimited_4", true);
				end_Hash.put("tFileInputDelimited_4", System.currentTimeMillis());

				/**
				 * [tFileInputDelimited_4 end ] stop
				 */

				/**
				 * [tAdvancedHash_row4 end ] start
				 */

				currentComponent = "tAdvancedHash_row4";

				tHash_Lookup_row4.endPut();

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row4");
				}

				ok_Hash.put("tAdvancedHash_row4", true);
				end_Hash.put("tAdvancedHash_row4", System.currentTimeMillis());

				/**
				 * [tAdvancedHash_row4 end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tFileInputDelimited_4 finally ] start
				 */

				currentComponent = "tFileInputDelimited_4";

				/**
				 * [tFileInputDelimited_4 finally ] stop
				 */

				/**
				 * [tAdvancedHash_row4 finally ] start
				 */

				currentComponent = "tAdvancedHash_row4";

				/**
				 * [tAdvancedHash_row4 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tFileInputDelimited_4_SUBPROCESS_STATE", 1);
	}

	public static class actor_movie_date_ratingStruct
			implements routines.system.IPersistableRow<actor_movie_date_ratingStruct> {
		final static byte[] commonByteArrayLock_IMDB_factMovies = new byte[0];
		static byte[] commonByteArray_IMDB_factMovies = new byte[0];

		public String IdMovie;

		public String getIdMovie() {
			return this.IdMovie;
		}

		public String IdActor;

		public String getIdActor() {
			return this.IdActor;
		}

		public String IdWriter;

		public String getIdWriter() {
			return this.IdWriter;
		}

		public Integer IdDate;

		public Integer getIdDate() {
			return this.IdDate;
		}

		public String runtimeMinutes_1;

		public String getRuntimeMinutes_1() {
			return this.runtimeMinutes_1;
		}

		public Float averageRating;

		public Float getAverageRating() {
			return this.averageRating;
		}

		public String Revenue__Millions;

		public String getRevenue__Millions() {
			return this.Revenue__Millions;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_IMDB_factMovies.length) {
					if (length < 1024 && commonByteArray_IMDB_factMovies.length == 0) {
						commonByteArray_IMDB_factMovies = new byte[1024];
					} else {
						commonByteArray_IMDB_factMovies = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_IMDB_factMovies, 0, length);
				strReturn = new String(commonByteArray_IMDB_factMovies, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_IMDB_factMovies.length) {
					if (length < 1024 && commonByteArray_IMDB_factMovies.length == 0) {
						commonByteArray_IMDB_factMovies = new byte[1024];
					} else {
						commonByteArray_IMDB_factMovies = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_IMDB_factMovies, 0, length);
				strReturn = new String(commonByteArray_IMDB_factMovies, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_IMDB_factMovies) {

				try {

					int length = 0;

					this.IdMovie = readString(dis);

					this.IdActor = readString(dis);

					this.IdWriter = readString(dis);

					this.IdDate = readInteger(dis);

					this.runtimeMinutes_1 = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.averageRating = null;
					} else {
						this.averageRating = dis.readFloat();
					}

					this.Revenue__Millions = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_IMDB_factMovies) {

				try {

					int length = 0;

					this.IdMovie = readString(dis);

					this.IdActor = readString(dis);

					this.IdWriter = readString(dis);

					this.IdDate = readInteger(dis);

					this.runtimeMinutes_1 = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.averageRating = null;
					} else {
						this.averageRating = dis.readFloat();
					}

					this.Revenue__Millions = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.IdMovie, dos);

				// String

				writeString(this.IdActor, dos);

				// String

				writeString(this.IdWriter, dos);

				// Integer

				writeInteger(this.IdDate, dos);

				// String

				writeString(this.runtimeMinutes_1, dos);

				// Float

				if (this.averageRating == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.averageRating);
				}

				// String

				writeString(this.Revenue__Millions, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.IdMovie, dos);

				// String

				writeString(this.IdActor, dos);

				// String

				writeString(this.IdWriter, dos);

				// Integer

				writeInteger(this.IdDate, dos);

				// String

				writeString(this.runtimeMinutes_1, dos);

				// Float

				if (this.averageRating == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.averageRating);
				}

				// String

				writeString(this.Revenue__Millions, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("IdMovie=" + IdMovie);
			sb.append(",IdActor=" + IdActor);
			sb.append(",IdWriter=" + IdWriter);
			sb.append(",IdDate=" + String.valueOf(IdDate));
			sb.append(",runtimeMinutes_1=" + runtimeMinutes_1);
			sb.append(",averageRating=" + String.valueOf(averageRating));
			sb.append(",Revenue__Millions=" + Revenue__Millions);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(actor_movie_date_ratingStruct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class ratingStruct implements routines.system.IPersistableRow<ratingStruct> {
		final static byte[] commonByteArrayLock_IMDB_factMovies = new byte[0];
		static byte[] commonByteArray_IMDB_factMovies = new byte[0];

		public String tconst;

		public String getTconst() {
			return this.tconst;
		}

		public Float averageRating;

		public Float getAverageRating() {
			return this.averageRating;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_IMDB_factMovies.length) {
					if (length < 1024 && commonByteArray_IMDB_factMovies.length == 0) {
						commonByteArray_IMDB_factMovies = new byte[1024];
					} else {
						commonByteArray_IMDB_factMovies = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_IMDB_factMovies, 0, length);
				strReturn = new String(commonByteArray_IMDB_factMovies, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_IMDB_factMovies.length) {
					if (length < 1024 && commonByteArray_IMDB_factMovies.length == 0) {
						commonByteArray_IMDB_factMovies = new byte[1024];
					} else {
						commonByteArray_IMDB_factMovies = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_IMDB_factMovies, 0, length);
				strReturn = new String(commonByteArray_IMDB_factMovies, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_IMDB_factMovies) {

				try {

					int length = 0;

					this.tconst = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.averageRating = null;
					} else {
						this.averageRating = dis.readFloat();
					}

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_IMDB_factMovies) {

				try {

					int length = 0;

					this.tconst = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.averageRating = null;
					} else {
						this.averageRating = dis.readFloat();
					}

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.tconst, dos);

				// Float

				if (this.averageRating == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.averageRating);
				}

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.tconst, dos);

				// Float

				if (this.averageRating == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.averageRating);
				}

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("tconst=" + tconst);
			sb.append(",averageRating=" + String.valueOf(averageRating));
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(ratingStruct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class row5Struct implements routines.system.IPersistableRow<row5Struct> {
		final static byte[] commonByteArrayLock_IMDB_factMovies = new byte[0];
		static byte[] commonByteArray_IMDB_factMovies = new byte[0];

		public String tconst;

		public String getTconst() {
			return this.tconst;
		}

		public Float averageRating;

		public Float getAverageRating() {
			return this.averageRating;
		}

		public Integer numVotes;

		public Integer getNumVotes() {
			return this.numVotes;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_IMDB_factMovies.length) {
					if (length < 1024 && commonByteArray_IMDB_factMovies.length == 0) {
						commonByteArray_IMDB_factMovies = new byte[1024];
					} else {
						commonByteArray_IMDB_factMovies = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_IMDB_factMovies, 0, length);
				strReturn = new String(commonByteArray_IMDB_factMovies, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_IMDB_factMovies.length) {
					if (length < 1024 && commonByteArray_IMDB_factMovies.length == 0) {
						commonByteArray_IMDB_factMovies = new byte[1024];
					} else {
						commonByteArray_IMDB_factMovies = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_IMDB_factMovies, 0, length);
				strReturn = new String(commonByteArray_IMDB_factMovies, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_IMDB_factMovies) {

				try {

					int length = 0;

					this.tconst = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.averageRating = null;
					} else {
						this.averageRating = dis.readFloat();
					}

					this.numVotes = readInteger(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_IMDB_factMovies) {

				try {

					int length = 0;

					this.tconst = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.averageRating = null;
					} else {
						this.averageRating = dis.readFloat();
					}

					this.numVotes = readInteger(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.tconst, dos);

				// Float

				if (this.averageRating == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.averageRating);
				}

				// Integer

				writeInteger(this.numVotes, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.tconst, dos);

				// Float

				if (this.averageRating == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.averageRating);
				}

				// Integer

				writeInteger(this.numVotes, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("tconst=" + tconst);
			sb.append(",averageRating=" + String.valueOf(averageRating));
			sb.append(",numVotes=" + String.valueOf(numVotes));
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row5Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class after_tFileInputDelimited_5Struct
			implements routines.system.IPersistableRow<after_tFileInputDelimited_5Struct> {
		final static byte[] commonByteArrayLock_IMDB_factMovies = new byte[0];
		static byte[] commonByteArray_IMDB_factMovies = new byte[0];

		public String tconst;

		public String getTconst() {
			return this.tconst;
		}

		public Float averageRating;

		public Float getAverageRating() {
			return this.averageRating;
		}

		public Integer numVotes;

		public Integer getNumVotes() {
			return this.numVotes;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_IMDB_factMovies.length) {
					if (length < 1024 && commonByteArray_IMDB_factMovies.length == 0) {
						commonByteArray_IMDB_factMovies = new byte[1024];
					} else {
						commonByteArray_IMDB_factMovies = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_IMDB_factMovies, 0, length);
				strReturn = new String(commonByteArray_IMDB_factMovies, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_IMDB_factMovies.length) {
					if (length < 1024 && commonByteArray_IMDB_factMovies.length == 0) {
						commonByteArray_IMDB_factMovies = new byte[1024];
					} else {
						commonByteArray_IMDB_factMovies = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_IMDB_factMovies, 0, length);
				strReturn = new String(commonByteArray_IMDB_factMovies, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_IMDB_factMovies) {

				try {

					int length = 0;

					this.tconst = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.averageRating = null;
					} else {
						this.averageRating = dis.readFloat();
					}

					this.numVotes = readInteger(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_IMDB_factMovies) {

				try {

					int length = 0;

					this.tconst = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.averageRating = null;
					} else {
						this.averageRating = dis.readFloat();
					}

					this.numVotes = readInteger(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.tconst, dos);

				// Float

				if (this.averageRating == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.averageRating);
				}

				// Integer

				writeInteger(this.numVotes, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.tconst, dos);

				// Float

				if (this.averageRating == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.averageRating);
				}

				// Integer

				writeInteger(this.numVotes, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("tconst=" + tconst);
			sb.append(",averageRating=" + String.valueOf(averageRating));
			sb.append(",numVotes=" + String.valueOf(numVotes));
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(after_tFileInputDelimited_5Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tFileInputDelimited_5Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tFileInputDelimited_5_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				tFileInputDelimited_3Process(globalMap);

				row5Struct row5 = new row5Struct();
				ratingStruct rating = new ratingStruct();
				actor_movie_date_ratingStruct actor_movie_date_rating = new actor_movie_date_ratingStruct();

				/**
				 * [tDBOutput_1 begin ] start
				 */

				ok_Hash.put("tDBOutput_1", false);
				start_Hash.put("tDBOutput_1", System.currentTimeMillis());

				currentComponent = "tDBOutput_1";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "actor_movie_date_rating");
				}

				int tos_count_tDBOutput_1 = 0;

				String dbschema_tDBOutput_1 = null;
				dbschema_tDBOutput_1 = "public";

				String tableName_tDBOutput_1 = null;
				if (dbschema_tDBOutput_1 == null || dbschema_tDBOutput_1.trim().length() == 0) {
					tableName_tDBOutput_1 = ("movie_fact");
				} else {
					tableName_tDBOutput_1 = dbschema_tDBOutput_1 + "\".\"" + ("movie_fact");
				}

				int deleteKeyCount_tDBOutput_1 = 0;
				if (deleteKeyCount_tDBOutput_1 < 1) {
					throw new RuntimeException("For delete, Schema must have a key");
				}

				int nb_line_tDBOutput_1 = 0;
				int nb_line_update_tDBOutput_1 = 0;
				int nb_line_inserted_tDBOutput_1 = 0;
				int nb_line_deleted_tDBOutput_1 = 0;
				int nb_line_rejected_tDBOutput_1 = 0;

				int deletedCount_tDBOutput_1 = 0;
				int updatedCount_tDBOutput_1 = 0;
				int insertedCount_tDBOutput_1 = 0;
				int rowsToCommitCount_tDBOutput_1 = 0;
				int rejectedCount_tDBOutput_1 = 0;

				boolean whetherReject_tDBOutput_1 = false;

				java.sql.Connection conn_tDBOutput_1 = null;
				String dbUser_tDBOutput_1 = null;

				java.lang.Class.forName("org.postgresql.Driver");

				String url_tDBOutput_1 = "jdbc:postgresql://" + "localhost" + ":" + "5432" + "/" + "imdb";
				dbUser_tDBOutput_1 = "postgres";

				final String decryptedPassword_tDBOutput_1 = routines.system.PasswordEncryptUtil.decryptPassword(
						"enc:routine.encryption.key.v1:j88T89/uTiMuPQjEroXkGAZXEm7g+aeevL7Dg1cf8ZBVtfth9hpUYg==");

				String dbPwd_tDBOutput_1 = decryptedPassword_tDBOutput_1;

				conn_tDBOutput_1 = java.sql.DriverManager.getConnection(url_tDBOutput_1, dbUser_tDBOutput_1,
						dbPwd_tDBOutput_1);

				resourceMap.put("conn_tDBOutput_1", conn_tDBOutput_1);
				conn_tDBOutput_1.setAutoCommit(false);
				int commitEvery_tDBOutput_1 = 10000;
				int commitCounter_tDBOutput_1 = 0;

				int batchSize_tDBOutput_1 = 10000;
				int batchSizeCounter_tDBOutput_1 = 0;

				int count_tDBOutput_1 = 0;
				String delete_tDBOutput_1 = "DELETE FROM \"" + tableName_tDBOutput_1 + "\" WHERE ";
				java.sql.PreparedStatement pstmt_tDBOutput_1 = conn_tDBOutput_1.prepareStatement(delete_tDBOutput_1);
				resourceMap.put("pstmt_tDBOutput_1", pstmt_tDBOutput_1);

				/**
				 * [tDBOutput_1 begin ] stop
				 */

				/**
				 * [tMap_4 begin ] start
				 */

				ok_Hash.put("tMap_4", false);
				start_Hash.put("tMap_4", System.currentTimeMillis());

				currentComponent = "tMap_4";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "rating");
				}

				int tos_count_tMap_4 = 0;

// ###############################
// # Lookup's keys initialization

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<actor_movie_writerStruct> tHash_Lookup_actor_movie_writer = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<actor_movie_writerStruct>) ((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<actor_movie_writerStruct>) globalMap
						.get("tHash_Lookup_actor_movie_writer"));

				actor_movie_writerStruct actor_movie_writerHashKey = new actor_movie_writerStruct();
				actor_movie_writerStruct actor_movie_writerDefault = new actor_movie_writerStruct();
// ###############################        

// ###############################
// # Vars initialization
				class Var__tMap_4__Struct {
				}
				Var__tMap_4__Struct Var__tMap_4 = new Var__tMap_4__Struct();
// ###############################

// ###############################
// # Outputs initialization
				actor_movie_date_ratingStruct actor_movie_date_rating_tmp = new actor_movie_date_ratingStruct();
// ###############################

				/**
				 * [tMap_4 begin ] stop
				 */

				/**
				 * [tMap_6 begin ] start
				 */

				ok_Hash.put("tMap_6", false);
				start_Hash.put("tMap_6", System.currentTimeMillis());

				currentComponent = "tMap_6";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row5");
				}

				int tos_count_tMap_6 = 0;

// ###############################
// # Lookup's keys initialization
// ###############################        

// ###############################
// # Vars initialization
				class Var__tMap_6__Struct {
				}
				Var__tMap_6__Struct Var__tMap_6 = new Var__tMap_6__Struct();
// ###############################

// ###############################
// # Outputs initialization
				ratingStruct rating_tmp = new ratingStruct();
// ###############################

				/**
				 * [tMap_6 begin ] stop
				 */

				/**
				 * [tFileInputDelimited_5 begin ] start
				 */

				ok_Hash.put("tFileInputDelimited_5", false);
				start_Hash.put("tFileInputDelimited_5", System.currentTimeMillis());

				currentComponent = "tFileInputDelimited_5";

				int tos_count_tFileInputDelimited_5 = 0;

				final routines.system.RowState rowstate_tFileInputDelimited_5 = new routines.system.RowState();

				int nb_line_tFileInputDelimited_5 = 0;
				org.talend.fileprocess.FileInputDelimited fid_tFileInputDelimited_5 = null;
				int limit_tFileInputDelimited_5 = 500000;
				try {

					Object filename_tFileInputDelimited_5 = "C:/Users/ZMERLI/Downloads/imdb dataset/title.ratings.tsv/title.ratings.tsv";
					if (filename_tFileInputDelimited_5 instanceof java.io.InputStream) {

						int footer_value_tFileInputDelimited_5 = 0, random_value_tFileInputDelimited_5 = -1;
						if (footer_value_tFileInputDelimited_5 > 0 || random_value_tFileInputDelimited_5 > 0) {
							throw new java.lang.Exception(
									"When the input source is a stream,footer and random shouldn't be bigger than 0.");
						}

					}
					try {
						fid_tFileInputDelimited_5 = new org.talend.fileprocess.FileInputDelimited(
								"C:/Users/ZMERLI/Downloads/imdb dataset/title.ratings.tsv/title.ratings.tsv",
								"US-ASCII", "\t", "\n", false, 1, 0, limit_tFileInputDelimited_5, -1, false);
					} catch (java.lang.Exception e) {
						globalMap.put("tFileInputDelimited_5_ERROR_MESSAGE", e.getMessage());

						System.err.println(e.getMessage());

					}

					while (fid_tFileInputDelimited_5 != null && fid_tFileInputDelimited_5.nextRecord()) {
						rowstate_tFileInputDelimited_5.reset();

						row5 = null;

						boolean whetherReject_tFileInputDelimited_5 = false;
						row5 = new row5Struct();
						try {

							int columnIndexWithD_tFileInputDelimited_5 = 0;

							String temp = "";

							columnIndexWithD_tFileInputDelimited_5 = 0;

							row5.tconst = fid_tFileInputDelimited_5.get(columnIndexWithD_tFileInputDelimited_5);

							columnIndexWithD_tFileInputDelimited_5 = 1;

							temp = fid_tFileInputDelimited_5.get(columnIndexWithD_tFileInputDelimited_5);
							if (temp.length() > 0) {

								try {

									row5.averageRating = ParserUtils.parseTo_Float(temp);

								} catch (java.lang.Exception ex_tFileInputDelimited_5) {
									globalMap.put("tFileInputDelimited_5_ERROR_MESSAGE",
											ex_tFileInputDelimited_5.getMessage());
									rowstate_tFileInputDelimited_5.setException(new RuntimeException(String.format(
											"Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
											"averageRating", "row5", temp, ex_tFileInputDelimited_5),
											ex_tFileInputDelimited_5));
								}

							} else {

								row5.averageRating = null;

							}

							columnIndexWithD_tFileInputDelimited_5 = 2;

							temp = fid_tFileInputDelimited_5.get(columnIndexWithD_tFileInputDelimited_5);
							if (temp.length() > 0) {

								try {

									row5.numVotes = ParserUtils.parseTo_Integer(temp);

								} catch (java.lang.Exception ex_tFileInputDelimited_5) {
									globalMap.put("tFileInputDelimited_5_ERROR_MESSAGE",
											ex_tFileInputDelimited_5.getMessage());
									rowstate_tFileInputDelimited_5.setException(new RuntimeException(String.format(
											"Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
											"numVotes", "row5", temp, ex_tFileInputDelimited_5),
											ex_tFileInputDelimited_5));
								}

							} else {

								row5.numVotes = null;

							}

							if (rowstate_tFileInputDelimited_5.getException() != null) {
								throw rowstate_tFileInputDelimited_5.getException();
							}

						} catch (java.lang.Exception e) {
							globalMap.put("tFileInputDelimited_5_ERROR_MESSAGE", e.getMessage());
							whetherReject_tFileInputDelimited_5 = true;

							System.err.println(e.getMessage());
							row5 = null;

						}

						/**
						 * [tFileInputDelimited_5 begin ] stop
						 */

						/**
						 * [tFileInputDelimited_5 main ] start
						 */

						currentComponent = "tFileInputDelimited_5";

						tos_count_tFileInputDelimited_5++;

						/**
						 * [tFileInputDelimited_5 main ] stop
						 */

						/**
						 * [tFileInputDelimited_5 process_data_begin ] start
						 */

						currentComponent = "tFileInputDelimited_5";

						/**
						 * [tFileInputDelimited_5 process_data_begin ] stop
						 */
// Start of branch "row5"
						if (row5 != null) {

							/**
							 * [tMap_6 main ] start
							 */

							currentComponent = "tMap_6";

							if (execStat) {
								runStat.updateStatOnConnection(iterateId, 1, 1

										, "row5"

								);
							}

							boolean hasCasePrimitiveKeyWithNull_tMap_6 = false;

							// ###############################
							// # Input tables (lookups)
							boolean rejectedInnerJoin_tMap_6 = false;
							boolean mainRowRejected_tMap_6 = false;

							// ###############################
							{ // start of Var scope

								// ###############################
								// # Vars tables

								Var__tMap_6__Struct Var = Var__tMap_6;// ###############################
								// ###############################
								// # Output tables

								rating = null;

// # Output table : 'rating'
								rating_tmp.tconst = row5.tconst;
								rating_tmp.averageRating = row5.averageRating;
								rating = rating_tmp;
// ###############################

							} // end of Var scope

							rejectedInnerJoin_tMap_6 = false;

							tos_count_tMap_6++;

							/**
							 * [tMap_6 main ] stop
							 */

							/**
							 * [tMap_6 process_data_begin ] start
							 */

							currentComponent = "tMap_6";

							/**
							 * [tMap_6 process_data_begin ] stop
							 */
// Start of branch "rating"
							if (rating != null) {

								/**
								 * [tMap_4 main ] start
								 */

								currentComponent = "tMap_4";

								if (execStat) {
									runStat.updateStatOnConnection(iterateId, 1, 1

											, "rating"

									);
								}

								boolean hasCasePrimitiveKeyWithNull_tMap_4 = false;

								// ###############################
								// # Input tables (lookups)
								boolean rejectedInnerJoin_tMap_4 = false;
								boolean mainRowRejected_tMap_4 = false;

								///////////////////////////////////////////////
								// Starting Lookup Table "actor_movie_writer"
								///////////////////////////////////////////////

								boolean forceLoopactor_movie_writer = false;

								actor_movie_writerStruct actor_movie_writerObjectFromLookup = null;

								if (!rejectedInnerJoin_tMap_4) { // G_TM_M_020

									hasCasePrimitiveKeyWithNull_tMap_4 = false;

									actor_movie_writerHashKey.IdMovie = rating.tconst;

									actor_movie_writerHashKey.hashCodeDirty = true;

									tHash_Lookup_actor_movie_writer.lookup(actor_movie_writerHashKey);

									if (!tHash_Lookup_actor_movie_writer.hasNext()) { // G_TM_M_090

										rejectedInnerJoin_tMap_4 = true;

										forceLoopactor_movie_writer = true;

									} // G_TM_M_090

								} // G_TM_M_020

								else { // G 20 - G 21
									forceLoopactor_movie_writer = true;
								} // G 21

								actor_movie_writerStruct actor_movie_writer = null;

								while ((tHash_Lookup_actor_movie_writer != null
										&& tHash_Lookup_actor_movie_writer.hasNext()) || forceLoopactor_movie_writer) { // G_TM_M_043

									// CALL close loop of lookup 'actor_movie_writer'

									actor_movie_writerStruct fromLookup_actor_movie_writer = null;
									actor_movie_writer = actor_movie_writerDefault;

									if (!forceLoopactor_movie_writer) { // G 46

										fromLookup_actor_movie_writer = tHash_Lookup_actor_movie_writer.next();

										if (fromLookup_actor_movie_writer != null) {
											actor_movie_writer = fromLookup_actor_movie_writer;
										}

									} // G 46

									forceLoopactor_movie_writer = false;

									// ###############################
									{ // start of Var scope

										// ###############################
										// # Vars tables

										Var__tMap_4__Struct Var = Var__tMap_4;// ###############################
										// ###############################
										// # Output tables

										actor_movie_date_rating = null;

										if (!rejectedInnerJoin_tMap_4) {

// # Output table : 'actor_movie_date_rating'
											actor_movie_date_rating_tmp.IdMovie = actor_movie_writer.IdMovie;
											actor_movie_date_rating_tmp.IdActor = actor_movie_writer.IdActor;
											actor_movie_date_rating_tmp.IdWriter = actor_movie_writer.IdWriter;
											actor_movie_date_rating_tmp.IdDate = actor_movie_writer.IdDate;
											actor_movie_date_rating_tmp.runtimeMinutes_1 = actor_movie_writer.runtimeMinutes_1;
											actor_movie_date_rating_tmp.averageRating = rating.averageRating;
											actor_movie_date_rating_tmp.Revenue__Millions = actor_movie_writer.Revenue__Millions;
											actor_movie_date_rating = actor_movie_date_rating_tmp;
										} // closing inner join bracket (2)
// ###############################

									} // end of Var scope

									rejectedInnerJoin_tMap_4 = false;

									tos_count_tMap_4++;

									/**
									 * [tMap_4 main ] stop
									 */

									/**
									 * [tMap_4 process_data_begin ] start
									 */

									currentComponent = "tMap_4";

									/**
									 * [tMap_4 process_data_begin ] stop
									 */
// Start of branch "actor_movie_date_rating"
									if (actor_movie_date_rating != null) {

										/**
										 * [tDBOutput_1 main ] start
										 */

										currentComponent = "tDBOutput_1";

										if (execStat) {
											runStat.updateStatOnConnection(iterateId, 1, 1

													, "actor_movie_date_rating"

											);
										}

										whetherReject_tDBOutput_1 = false;
										pstmt_tDBOutput_1.addBatch();
										nb_line_tDBOutput_1++;

										batchSizeCounter_tDBOutput_1++;

										if ((batchSize_tDBOutput_1 > 0)
												&& (batchSize_tDBOutput_1 <= batchSizeCounter_tDBOutput_1)) {
											try {
												int countSum_tDBOutput_1 = 0;

												for (int countEach_tDBOutput_1 : pstmt_tDBOutput_1.executeBatch()) {
													countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0
															: countEach_tDBOutput_1);
												}
												rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;

												deletedCount_tDBOutput_1 += countSum_tDBOutput_1;

												batchSizeCounter_tDBOutput_1 = 0;
											} catch (java.sql.BatchUpdateException e_tDBOutput_1) {
												globalMap.put("tDBOutput_1_ERROR_MESSAGE", e_tDBOutput_1.getMessage());
												java.sql.SQLException ne_tDBOutput_1 = e_tDBOutput_1.getNextException(),
														sqle_tDBOutput_1 = null;
												String errormessage_tDBOutput_1;
												if (ne_tDBOutput_1 != null) {
													// build new exception to provide the original cause
													sqle_tDBOutput_1 = new java.sql.SQLException(
															e_tDBOutput_1.getMessage() + "\ncaused by: "
																	+ ne_tDBOutput_1.getMessage(),
															ne_tDBOutput_1.getSQLState(), ne_tDBOutput_1.getErrorCode(),
															ne_tDBOutput_1);
													errormessage_tDBOutput_1 = sqle_tDBOutput_1.getMessage();
												} else {
													errormessage_tDBOutput_1 = e_tDBOutput_1.getMessage();
												}

												int countSum_tDBOutput_1 = 0;
												for (int countEach_tDBOutput_1 : e_tDBOutput_1.getUpdateCounts()) {
													countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0
															: countEach_tDBOutput_1);
												}
												rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;

												deletedCount_tDBOutput_1 += countSum_tDBOutput_1;

												System.err.println(errormessage_tDBOutput_1);

											}
										}

										commitCounter_tDBOutput_1++;
										if (commitEvery_tDBOutput_1 <= commitCounter_tDBOutput_1) {
											if ((batchSize_tDBOutput_1 > 0) && (batchSizeCounter_tDBOutput_1 > 0)) {
												try {
													int countSum_tDBOutput_1 = 0;

													for (int countEach_tDBOutput_1 : pstmt_tDBOutput_1.executeBatch()) {
														countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0
																: countEach_tDBOutput_1);
													}
													rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;

													deletedCount_tDBOutput_1 += countSum_tDBOutput_1;

													batchSizeCounter_tDBOutput_1 = 0;
												} catch (java.sql.BatchUpdateException e_tDBOutput_1) {
													globalMap.put("tDBOutput_1_ERROR_MESSAGE",
															e_tDBOutput_1.getMessage());
													java.sql.SQLException ne_tDBOutput_1 = e_tDBOutput_1
															.getNextException(), sqle_tDBOutput_1 = null;
													String errormessage_tDBOutput_1;
													if (ne_tDBOutput_1 != null) {
														// build new exception to provide the original cause
														sqle_tDBOutput_1 = new java.sql.SQLException(
																e_tDBOutput_1.getMessage() + "\ncaused by: "
																		+ ne_tDBOutput_1.getMessage(),
																ne_tDBOutput_1.getSQLState(),
																ne_tDBOutput_1.getErrorCode(), ne_tDBOutput_1);
														errormessage_tDBOutput_1 = sqle_tDBOutput_1.getMessage();
													} else {
														errormessage_tDBOutput_1 = e_tDBOutput_1.getMessage();
													}

													int countSum_tDBOutput_1 = 0;
													for (int countEach_tDBOutput_1 : e_tDBOutput_1.getUpdateCounts()) {
														countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0
																: countEach_tDBOutput_1);
													}
													rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;

													deletedCount_tDBOutput_1 += countSum_tDBOutput_1;

													System.err.println(errormessage_tDBOutput_1);

												}
											}
											if (rowsToCommitCount_tDBOutput_1 != 0) {

											}
											conn_tDBOutput_1.commit();
											if (rowsToCommitCount_tDBOutput_1 != 0) {

												rowsToCommitCount_tDBOutput_1 = 0;
											}
											commitCounter_tDBOutput_1 = 0;
										}

										tos_count_tDBOutput_1++;

										/**
										 * [tDBOutput_1 main ] stop
										 */

										/**
										 * [tDBOutput_1 process_data_begin ] start
										 */

										currentComponent = "tDBOutput_1";

										/**
										 * [tDBOutput_1 process_data_begin ] stop
										 */

										/**
										 * [tDBOutput_1 process_data_end ] start
										 */

										currentComponent = "tDBOutput_1";

										/**
										 * [tDBOutput_1 process_data_end ] stop
										 */

									} // End of branch "actor_movie_date_rating"

								} // close loop of lookup 'actor_movie_writer' // G_TM_M_043

								/**
								 * [tMap_4 process_data_end ] start
								 */

								currentComponent = "tMap_4";

								/**
								 * [tMap_4 process_data_end ] stop
								 */

							} // End of branch "rating"

							/**
							 * [tMap_6 process_data_end ] start
							 */

							currentComponent = "tMap_6";

							/**
							 * [tMap_6 process_data_end ] stop
							 */

						} // End of branch "row5"

						/**
						 * [tFileInputDelimited_5 process_data_end ] start
						 */

						currentComponent = "tFileInputDelimited_5";

						/**
						 * [tFileInputDelimited_5 process_data_end ] stop
						 */

						/**
						 * [tFileInputDelimited_5 end ] start
						 */

						currentComponent = "tFileInputDelimited_5";

					}
				} finally {
					if (!((Object) ("C:/Users/ZMERLI/Downloads/imdb dataset/title.ratings.tsv/title.ratings.tsv") instanceof java.io.InputStream)) {
						if (fid_tFileInputDelimited_5 != null) {
							fid_tFileInputDelimited_5.close();
						}
					}
					if (fid_tFileInputDelimited_5 != null) {
						globalMap.put("tFileInputDelimited_5_NB_LINE", fid_tFileInputDelimited_5.getRowNumber());

					}
				}

				ok_Hash.put("tFileInputDelimited_5", true);
				end_Hash.put("tFileInputDelimited_5", System.currentTimeMillis());

				/**
				 * [tFileInputDelimited_5 end ] stop
				 */

				/**
				 * [tMap_6 end ] start
				 */

				currentComponent = "tMap_6";

// ###############################
// # Lookup hashes releasing
// ###############################      

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row5");
				}

				ok_Hash.put("tMap_6", true);
				end_Hash.put("tMap_6", System.currentTimeMillis());

				/**
				 * [tMap_6 end ] stop
				 */

				/**
				 * [tMap_4 end ] start
				 */

				currentComponent = "tMap_4";

// ###############################
// # Lookup hashes releasing
				if (tHash_Lookup_actor_movie_writer != null) {
					tHash_Lookup_actor_movie_writer.endGet();
				}
				globalMap.remove("tHash_Lookup_actor_movie_writer");

// ###############################      

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "rating");
				}

				ok_Hash.put("tMap_4", true);
				end_Hash.put("tMap_4", System.currentTimeMillis());

				/**
				 * [tMap_4 end ] stop
				 */

				/**
				 * [tDBOutput_1 end ] start
				 */

				currentComponent = "tDBOutput_1";

				try {
					int countSum_tDBOutput_1 = 0;
					if (pstmt_tDBOutput_1 != null && batchSizeCounter_tDBOutput_1 > 0) {

						for (int countEach_tDBOutput_1 : pstmt_tDBOutput_1.executeBatch()) {
							countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
						}
						rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;

					}

					deletedCount_tDBOutput_1 += countSum_tDBOutput_1;

				} catch (java.sql.BatchUpdateException e_tDBOutput_1) {
					globalMap.put("tDBOutput_1_ERROR_MESSAGE", e_tDBOutput_1.getMessage());
					java.sql.SQLException ne_tDBOutput_1 = e_tDBOutput_1.getNextException(), sqle_tDBOutput_1 = null;
					String errormessage_tDBOutput_1;
					if (ne_tDBOutput_1 != null) {
						// build new exception to provide the original cause
						sqle_tDBOutput_1 = new java.sql.SQLException(
								e_tDBOutput_1.getMessage() + "\ncaused by: " + ne_tDBOutput_1.getMessage(),
								ne_tDBOutput_1.getSQLState(), ne_tDBOutput_1.getErrorCode(), ne_tDBOutput_1);
						errormessage_tDBOutput_1 = sqle_tDBOutput_1.getMessage();
					} else {
						errormessage_tDBOutput_1 = e_tDBOutput_1.getMessage();
					}

					int countSum_tDBOutput_1 = 0;
					for (int countEach_tDBOutput_1 : e_tDBOutput_1.getUpdateCounts()) {
						countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
					}
					rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;

					deletedCount_tDBOutput_1 += countSum_tDBOutput_1;

					System.err.println(errormessage_tDBOutput_1);

				}

				if (pstmt_tDBOutput_1 != null) {

					pstmt_tDBOutput_1.close();
					resourceMap.remove("pstmt_tDBOutput_1");
				}
				resourceMap.put("statementClosed_tDBOutput_1", true);
				if (rowsToCommitCount_tDBOutput_1 != 0) {

				}
				conn_tDBOutput_1.commit();
				if (rowsToCommitCount_tDBOutput_1 != 0) {

					rowsToCommitCount_tDBOutput_1 = 0;
				}
				commitCounter_tDBOutput_1 = 0;

				conn_tDBOutput_1.close();

				resourceMap.put("finish_tDBOutput_1", true);

				nb_line_deleted_tDBOutput_1 = nb_line_deleted_tDBOutput_1 + deletedCount_tDBOutput_1;
				nb_line_update_tDBOutput_1 = nb_line_update_tDBOutput_1 + updatedCount_tDBOutput_1;
				nb_line_inserted_tDBOutput_1 = nb_line_inserted_tDBOutput_1 + insertedCount_tDBOutput_1;
				nb_line_rejected_tDBOutput_1 = nb_line_rejected_tDBOutput_1 + rejectedCount_tDBOutput_1;

				globalMap.put("tDBOutput_1_NB_LINE", nb_line_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_UPDATED", nb_line_update_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_INSERTED", nb_line_inserted_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_DELETED", nb_line_deleted_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_1);

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "actor_movie_date_rating");
				}

				ok_Hash.put("tDBOutput_1", true);
				end_Hash.put("tDBOutput_1", System.currentTimeMillis());

				/**
				 * [tDBOutput_1 end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			// free memory for "tMap_4"
			globalMap.remove("tHash_Lookup_actor_movie_writer");

			try {

				/**
				 * [tFileInputDelimited_5 finally ] start
				 */

				currentComponent = "tFileInputDelimited_5";

				/**
				 * [tFileInputDelimited_5 finally ] stop
				 */

				/**
				 * [tMap_6 finally ] start
				 */

				currentComponent = "tMap_6";

				/**
				 * [tMap_6 finally ] stop
				 */

				/**
				 * [tMap_4 finally ] start
				 */

				currentComponent = "tMap_4";

				/**
				 * [tMap_4 finally ] stop
				 */

				/**
				 * [tDBOutput_1 finally ] start
				 */

				currentComponent = "tDBOutput_1";

				try {
					if (resourceMap.get("statementClosed_tDBOutput_1") == null) {
						java.sql.PreparedStatement pstmtToClose_tDBOutput_1 = null;
						if ((pstmtToClose_tDBOutput_1 = (java.sql.PreparedStatement) resourceMap
								.remove("pstmt_tDBOutput_1")) != null) {
							pstmtToClose_tDBOutput_1.close();
						}
					}
				} finally {
					if (resourceMap.get("finish_tDBOutput_1") == null) {
						java.sql.Connection ctn_tDBOutput_1 = null;
						if ((ctn_tDBOutput_1 = (java.sql.Connection) resourceMap.get("conn_tDBOutput_1")) != null) {
							try {
								ctn_tDBOutput_1.close();
							} catch (java.sql.SQLException sqlEx_tDBOutput_1) {
								String errorMessage_tDBOutput_1 = "failed to close the connection in tDBOutput_1 :"
										+ sqlEx_tDBOutput_1.getMessage();
								System.err.println(errorMessage_tDBOutput_1);
							}
						}
					}
				}

				/**
				 * [tDBOutput_1 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tFileInputDelimited_5_SUBPROCESS_STATE", 1);
	}

	public String resuming_logs_dir_path = null;
	public String resuming_checkpoint_path = null;
	public String parent_part_launcher = null;
	private String resumeEntryMethodName = null;
	private boolean globalResumeTicket = false;

	public boolean watch = false;
	// portStats is null, it means don't execute the statistics
	public Integer portStats = null;
	public int portTraces = 4334;
	public String clientHost;
	public String defaultClientHost = "localhost";
	public String contextStr = "Default";
	public boolean isDefaultContext = true;
	public String pid = "0";
	public String rootPid = null;
	public String fatherPid = null;
	public String fatherNode = null;
	public long startTime = 0;
	public boolean isChildJob = false;
	public String log4jLevel = "";

	private boolean enableLogStash;

	private boolean execStat = true;

	private ThreadLocal<java.util.Map<String, String>> threadLocal = new ThreadLocal<java.util.Map<String, String>>() {
		protected java.util.Map<String, String> initialValue() {
			java.util.Map<String, String> threadRunResultMap = new java.util.HashMap<String, String>();
			threadRunResultMap.put("errorCode", null);
			threadRunResultMap.put("status", "");
			return threadRunResultMap;
		};
	};

	protected PropertiesWithType context_param = new PropertiesWithType();
	public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

	public String status = "";

	public static void main(String[] args) {
		final factMovies factMoviesClass = new factMovies();

		int exitCode = factMoviesClass.runJobInTOS(args);

		System.exit(exitCode);
	}

	public String[][] runJob(String[] args) {

		int exitCode = runJobInTOS(args);
		String[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };

		return bufferValue;
	}

	public boolean hastBufferOutputComponent() {
		boolean hastBufferOutput = false;

		return hastBufferOutput;
	}

	public int runJobInTOS(String[] args) {
		// reset status
		status = "";

		String lastStr = "";
		for (String arg : args) {
			if (arg.equalsIgnoreCase("--context_param")) {
				lastStr = arg;
			} else if (lastStr.equals("")) {
				evalParam(arg);
			} else {
				evalParam(lastStr + " " + arg);
				lastStr = "";
			}
		}
		enableLogStash = "true".equalsIgnoreCase(System.getProperty("audit.enabled"));

		if (clientHost == null) {
			clientHost = defaultClientHost;
		}

		if (pid == null || "0".equals(pid)) {
			pid = TalendString.getAsciiRandomString(6);
		}

		if (rootPid == null) {
			rootPid = pid;
		}
		if (fatherPid == null) {
			fatherPid = pid;
		} else {
			isChildJob = true;
		}

		if (portStats != null) {
			// portStats = -1; //for testing
			if (portStats < 0 || portStats > 65535) {
				// issue:10869, the portStats is invalid, so this client socket can't open
				System.err.println("The statistics socket port " + portStats + " is invalid.");
				execStat = false;
			}
		} else {
			execStat = false;
		}
		boolean inOSGi = routines.system.BundleUtils.inOSGi();

		if (inOSGi) {
			java.util.Dictionary<String, Object> jobProperties = routines.system.BundleUtils.getJobProperties(jobName);

			if (jobProperties != null && jobProperties.get("context") != null) {
				contextStr = (String) jobProperties.get("context");
			}
		}

		try {
			// call job/subjob with an existing context, like: --context=production. if
			// without this parameter, there will use the default context instead.
			java.io.InputStream inContext = factMovies.class.getClassLoader()
					.getResourceAsStream("imdb/factmovies_0_1/contexts/" + contextStr + ".properties");
			if (inContext == null) {
				inContext = factMovies.class.getClassLoader()
						.getResourceAsStream("config/contexts/" + contextStr + ".properties");
			}
			if (inContext != null) {
				try {
					// defaultProps is in order to keep the original context value
					if (context != null && context.isEmpty()) {
						defaultProps.load(inContext);
						context = new ContextProperties(defaultProps);
					}
				} finally {
					inContext.close();
				}
			} else if (!isDefaultContext) {
				// print info and job continue to run, for case: context_param is not empty.
				System.err.println("Could not find the context " + contextStr);
			}

			if (!context_param.isEmpty()) {
				context.putAll(context_param);
				// set types for params from parentJobs
				for (Object key : context_param.keySet()) {
					String context_key = key.toString();
					String context_type = context_param.getContextType(context_key);
					context.setContextType(context_key, context_type);

				}
			}
			class ContextProcessing {
				private void processContext_0() {
				}

				public void processAllContext() {
					processContext_0();
				}
			}

			new ContextProcessing().processAllContext();
		} catch (java.io.IOException ie) {
			System.err.println("Could not load context " + contextStr);
			ie.printStackTrace();
		}

		// get context value from parent directly
		if (parentContextMap != null && !parentContextMap.isEmpty()) {
		}

		// Resume: init the resumeUtil
		resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
		resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
		resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
		// Resume: jobStart
		resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "",
				"", "", "", "", resumeUtil.convertToJsonText(context, parametersToEncrypt));

		if (execStat) {
			try {
				runStat.openSocket(!isChildJob);
				runStat.setAllPID(rootPid, fatherPid, pid, jobName);
				runStat.startThreadStat(clientHost, portStats);
				runStat.updateStatOnJob(RunStat.JOBSTART, fatherNode);
			} catch (java.io.IOException ioException) {
				ioException.printStackTrace();
			}
		}

		java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<Object, Object>();
		globalMap.put("concurrentHashMap", concurrentHashMap);

		long startUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		long endUsedMemory = 0;
		long end = 0;

		startTime = System.currentTimeMillis();

		this.globalResumeTicket = true;// to run tPreJob

		this.globalResumeTicket = false;// to run others jobs

		try {
			errorCode = null;
			tFileInputDelimited_5Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tFileInputDelimited_5) {
			globalMap.put("tFileInputDelimited_5_SUBPROCESS_STATE", -1);

			e_tFileInputDelimited_5.printStackTrace();

		}

		this.globalResumeTicket = true;// to run tPostJob

		end = System.currentTimeMillis();

		if (watch) {
			System.out.println((end - startTime) + " milliseconds");
		}

		endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		if (false) {
			System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : factMovies");
		}

		if (execStat) {
			runStat.updateStatOnJob(RunStat.JOBEND, fatherNode);
			runStat.stopThreadStat();
		}
		int returnCode = 0;

		if (errorCode == null) {
			returnCode = status != null && status.equals("failure") ? 1 : 0;
		} else {
			returnCode = errorCode.intValue();
		}
		resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "",
				"" + returnCode, "", "", "");

		return returnCode;

	}

	// only for OSGi env
	public void destroy() {

	}

	private java.util.Map<String, Object> getSharedConnections4REST() {
		java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();

		return connections;
	}

	private void evalParam(String arg) {
		if (arg.startsWith("--resuming_logs_dir_path")) {
			resuming_logs_dir_path = arg.substring(25);
		} else if (arg.startsWith("--resuming_checkpoint_path")) {
			resuming_checkpoint_path = arg.substring(27);
		} else if (arg.startsWith("--parent_part_launcher")) {
			parent_part_launcher = arg.substring(23);
		} else if (arg.startsWith("--watch")) {
			watch = true;
		} else if (arg.startsWith("--stat_port=")) {
			String portStatsStr = arg.substring(12);
			if (portStatsStr != null && !portStatsStr.equals("null")) {
				portStats = Integer.parseInt(portStatsStr);
			}
		} else if (arg.startsWith("--trace_port=")) {
			portTraces = Integer.parseInt(arg.substring(13));
		} else if (arg.startsWith("--client_host=")) {
			clientHost = arg.substring(14);
		} else if (arg.startsWith("--context=")) {
			contextStr = arg.substring(10);
			isDefaultContext = false;
		} else if (arg.startsWith("--father_pid=")) {
			fatherPid = arg.substring(13);
		} else if (arg.startsWith("--root_pid=")) {
			rootPid = arg.substring(11);
		} else if (arg.startsWith("--father_node=")) {
			fatherNode = arg.substring(14);
		} else if (arg.startsWith("--pid=")) {
			pid = arg.substring(6);
		} else if (arg.startsWith("--context_type")) {
			String keyValue = arg.substring(15);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.setContextType(keyValue.substring(0, index),
							replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.setContextType(keyValue.substring(0, index), keyValue.substring(index + 1));
				}

			}

		} else if (arg.startsWith("--context_param")) {
			String keyValue = arg.substring(16);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1));
				}
			}
		} else if (arg.startsWith("--log4jLevel=")) {
			log4jLevel = arg.substring(13);
		} else if (arg.startsWith("--audit.enabled") && arg.contains("=")) {// for trunjob call
			final int equal = arg.indexOf('=');
			final String key = arg.substring("--".length(), equal);
			System.setProperty(key, arg.substring(equal + 1));
		}
	}

	private static final String NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY = "<TALEND_NULL>";

	private final String[][] escapeChars = { { "\\\\", "\\" }, { "\\n", "\n" }, { "\\'", "\'" }, { "\\r", "\r" },
			{ "\\f", "\f" }, { "\\b", "\b" }, { "\\t", "\t" } };

	private String replaceEscapeChars(String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0], currIndex);
				if (index >= 0) {

					result.append(keyValue.substring(currIndex, index + strArray[0].length()).replace(strArray[0],
							strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left into the
			// result
			if (index < 0) {
				result.append(keyValue.substring(currIndex));
				currIndex = currIndex + keyValue.length();
			}
		}

		return result.toString();
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public String getStatus() {
		return status;
	}

	ResumeUtil resumeUtil = null;
}
/************************************************************************************************
 * 287899 characters generated by Talend Open Studio for Data Integration on the
 * 28 novembre 2024, 11:33:03 AM CET
 ************************************************************************************************/