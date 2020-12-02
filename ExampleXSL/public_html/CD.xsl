<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="catalog">
<html> 
<head>
  <link href="CD.css" rel="stylesheet" type="text/css"/>
</head>
<body>
  <h2>My CD Collection</h2>
  <table border="1">
    <tr bgcolor="#9acd32">
      <th style="text-align:left" width="50%">Title</th>
      <th style="text-align:left">Price</th>
    </tr>
    <xsl:for-each select="cd">

        <tr>
            <td>
                <xsl:value-of select="title"/>
            </td>
            <td>
                <xsl:value-of select="price"/>
            </td>
        </tr>
    </xsl:for-each>
  </table>
  
</body>
</html>
</xsl:template>
</xsl:stylesheet>
