<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : style.xsl
    Created on : June 4, 2019, 1:09 PM
    Author     : Don OzOn
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="catalog">
        <html>
            <head>
                <title>CD Collection</title>
            </head>
            
            <body>
                <table border = "1">
                    <thead>
                        <td>Title</td>
                        <td>Price</td>
                    </thead>
                    
                    <xsl:for-each select="cd" >
                                <xsl:sort select="price" order="ascending" data-type="number"></xsl:sort>
                                <xsl:choose>
                                    <xsl:when test="price&lt;9">
                                        <tr>
                                            <td style= "background-color : red">
                                                
                                            </td>
                                        </tr>
                                        
                                        
                                    </xsl:when>
                                </xsl:choose>
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
