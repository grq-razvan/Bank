package layers.data;


;

public interface RecordSet {
	public boolean next();

	public java.lang.String getString(java.lang.String arg0);

	public boolean getBoolean(java.lang.String arg0);

	public byte getByte(java.lang.String arg0);

	public short getShort(java.lang.String arg0);

	public int getInt(java.lang.String arg0);

	public long getLong(java.lang.String arg0);

	public float getFloat(java.lang.String arg0);

	public double getDouble(java.lang.String arg0);

	public java.math.BigDecimal getBigDecimal(java.lang.String arg0, int arg1);

	public java.math.BigDecimal getBigDecimal(java.lang.String arg0);

	public java.sql.Date getDate(java.lang.String arg0);

	public boolean first();

	public boolean last();

	public boolean previous();
}
