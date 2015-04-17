<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="text"/>

	
	<xsl:template match="/">
		%INTRO%
		<xsl:apply-templates select="XMI/XMI.content/*[local-name()='Model']/*[local-name()='Namespace.ownedElement']/*[local-name()='Package']"/>
	</xsl:template>

	<xsl:template match="*[local-name()='Package']">
		<xsl:if test="@name!='java'">
			
			PACKAGE: <xsl:value-of select="@name"/>
			<xsl:apply-templates select="*[local-name()='Namespace.ownedElement']/*[local-name()='Class' or local-name()='Interface']"/>
		</xsl:if>
	</xsl:template>

	<!-- classi -->
	<xsl:template match="*[local-name()='Class']">

				CLASSE: <xsl:value-of select="@name"/>
				<xsl:apply-templates select="*[local-name()='ModelElement.visibility']"/>
				<xsl:apply-templates select="*[local-name()='ModelElement.definition']"/>
	</xsl:template>

	<!-- interfacce -->
	<xsl:template match="*[local-name()='Interface']">

				INTERFACCIA: <xsl:value-of select="@name"/>
				<xsl:apply-templates select="*[local-name()='ModelElement.visibility']"/>
				<xsl:apply-templates select="*[local-name()='ModelElement.definition']"/>
	</xsl:template>	

	<!-- visibilità -->
	<xsl:template match="*[local-name()='ModelElement.visibility']">
				VIS: <xsl:value-of select="@xmi.value"/>
	</xsl:template>

	<!-- definizione -->
	<xsl:template match="*[local-name()='ModelElement.definition']">
				DEF: <xsl:value-of select="@xmi.value"/>
	</xsl:template>

</xsl:stylesheet>
