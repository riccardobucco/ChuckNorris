<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="text"/>

	<xsl:template match="/terms">
		\begin{description}

		<xsl:for-each select="entry">
			<xsl:sort select="@name"/>

				\item[<xsl:value-of select="@name"/>]
				<xsl:value-of select="."/>

		</xsl:for-each>

		\end{description}
	</xsl:template>

	
</xsl:stylesheet>
