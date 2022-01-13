<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0">
<xsl:output method="html" encoding="UTF-8" indent="yes"/>
  <xsl:template match="/">
    <html>
      <body>
       <table>
        <tr><th>Datos</th><th></th><th>Notas</th></tr>
        <tr>
        <td>Nombre<td>Apellidos</td></td>        
        <td>Tareas <td>Cuestionarios</td><td>Examen</td><td>Final</td></td>
        </tr><tr></tr><tr></tr><tr></tr><tr></tr>
        <xsl:for-each select="/notas/alumno[@convocatoria='Junio']">
        <tr>
        <td><xsl:value-of select="nombre"/></td>
        <td><xsl:value-of select="apellidos"/></td>
        <td><xsl:value-of select="tareas"/></td>
        <td><xsl:value-of select="cuestionarios"/></td>
        <td><xsl:value-of select="examen"/></td>
        <xsl:choose>
          <xsl:when test="final&gt;=9"><td>SOBRESALIENTE</td></xsl:when>
          <xsl:when test="final&gt;=7"><td>NOTABLE</td></xsl:when>
          <xsl:when test="final&gt;=6"><td>BIEN</td></xsl:when>
          <xsl:when test="final&gt;=5"><td>SUFICIENTE</td></xsl:when>
          <xsl:otherwise><td>INSUFICIENTE</td></xsl:otherwise>
        </xsl:choose>
        </tr>
        </xsl:for-each>        
       </table>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
