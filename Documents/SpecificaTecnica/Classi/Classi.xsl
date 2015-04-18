<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="text"/>

	
	<xsl:template match="/">
		%INTRO%
		<xsl:apply-templates select="XMI/XMI.content/*[local-name()='Model']/*[local-name()='Namespace.ownedElement']/*[local-name()='Package']"/>
	</xsl:template>

	<xsl:template match="*[local-name()='Package']">
		<xsl:if test="@name!='java'">
			
			\level{3}{PIPPO::PLUTO::PAPERINO}
			\begin{itemize}
			\item Nome: <xsl:value-of select="@name"/>
			\item Tipo: package;
			\end{itemize}
			<xsl:apply-templates select="*[local-name()='Namespace.ownedElement']/*[local-name()='Class' or local-name()='Interface' or local-name()='Package']"/>
		</xsl:if>
	</xsl:template>

	<!-- classi -->
	<xsl:template match="*[local-name()='Class']">

			\level{3}{PIPPO::PLUTO::PAPERINO}
			\begin{itemize}
			\item Nome: <xsl:value-of select="@name"/>
			\item Tipo: classe;
			<xsl:apply-templates select="*[local-name()='ModelElement.visibility']"/>
			<xsl:apply-templates select="*[local-name()='ModelElement.definition']"/>
			\end{itemize}
			<xsl:apply-templates select="*[local-name()='Namespace.ownedElement']/*[local-name()='Class' or local-name()='Interface' or local-name()='Package']"/>			
	</xsl:template>

	<!-- interfacce -->
	<xsl:template match="*[local-name()='Interface']">

			\level{3}{PIPPO::PLUTO::PAPERINO}
			\begin{itemize}
			\item Nome: <xsl:value-of select="@name"/>
			\item Tipo: interfaccia;
			<xsl:apply-templates select="*[local-name()='ModelElement.visibility']"/>
			<xsl:apply-templates select="*[local-name()='ModelElement.definition']"/>
			\end{itemize}
			<xsl:apply-templates select="*[local-name()='Namespace.ownedElement']/*[local-name()='Class' or local-name()='Interface' or local-name()='Package']"/>
	</xsl:template>

	<!-- definizione -->
	<xsl:template match="*[local-name()='ModelElement.definition']">
			\item Descrizione: <xsl:value-of select="@xmi.value"/>;
	</xsl:template>

	<!-- visibilità -->
	<xsl:template match="*[local-name()='ModelElement.visibility']">
			\item Visibilità: <xsl:value-of select="@xmi.value"/>;
	</xsl:template>

</xsl:stylesheet>
