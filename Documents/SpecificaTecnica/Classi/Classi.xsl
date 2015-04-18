<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="text"/>

	
	<xsl:template match="/">
		%INTRO%
		<xsl:apply-templates select="XMI/XMI.content/*[local-name()='Model']/*[local-name()='Namespace.ownedElement']/*[local-name()='Package']"/>
	</xsl:template>

	<xsl:template match="*[local-name()='Package']">
		<xsl:if test="@name!='java'">
			
			\level{3}{<xsl:call-template name="namespace"><xsl:with-param name="id" select="@xmi.id"/></xsl:call-template>}
			\begin{itemize}
			\item Nome: <xsl:value-of select="@name"/>
			\item Tipo: package
			\end{itemize}
			<xsl:apply-templates select="*[local-name()='Namespace.ownedElement']/*[local-name()='Class' or local-name()='Interface' or local-name()='Package']"/>
		</xsl:if>
	</xsl:template>

	<!-- classi -->
	<xsl:template match="*[local-name()='Class']">

			\level{3}{<xsl:call-template name="namespace"><xsl:with-param name="id" select="@xmi.id"/></xsl:call-template>}
			\begin{itemize}
			\item Nome: <xsl:value-of select="@name"/>
			\item Tipo: classe
			<xsl:call-template name="abstract"/>
			<xsl:apply-templates select="*[local-name()='ModelElement.visibility']"/>
			<xsl:apply-templates select="*[local-name()='ModelElement.stereotype']"/>
			<xsl:apply-templates select="*[local-name()='ModelElement.definition']"/>
			\end{itemize}
			<xsl:apply-templates select="*[local-name()='Namespace.ownedElement']/*[local-name()='Class' or local-name()='Interface' or local-name()='Package']"/>			
	</xsl:template>

	<!-- interfacce -->
	<xsl:template match="*[local-name()='Interface']">

			\level{3}{<xsl:call-template name="namespace"><xsl:with-param name="id" select="@xmi.id"/></xsl:call-template>}
			\begin{itemize}
			\item Nome: <xsl:value-of select="@name"/>
			\item Tipo: interfaccia
			<xsl:apply-templates select="*[local-name()='ModelElement.visibility']"/>
			<xsl:apply-templates select="*[local-name()='ModelElement.definition']"/>
			\end{itemize}
			<xsl:apply-templates select="*[local-name()='Namespace.ownedElement']/*[local-name()='Class' or local-name()='Interface' or local-name()='Package']"/>
	</xsl:template>

	<!-- visibilità -->
	<xsl:template match="*[local-name()='ModelElement.visibility']">
			\item Visibilità: <xsl:value-of select="@xmi.value"/>
	</xsl:template>

	<!-- definizione -->
	<xsl:template match="*[local-name()='ModelElement.definition']">
			\item Descrizione: <xsl:value-of select="@xmi.value"/>
	</xsl:template>



	<!-- stereotipi -->
	<xsl:template match="*[local-name()='ModelElement.stereotype']">
		\item Stereotipi:
		\begin{itemize}
			<xsl:apply-templates select="*[local-name()='Stereotype']"/>
		\end{itemize}
	</xsl:template>

	<!-- stereotipi -->
	<xsl:template match="*[local-name()='Stereotype']">
		<xsl:param name="id" select="@xmi.idref"/>
		\item <xsl:value-of select="//*[@xmi.id=$id]/@name"/>
	</xsl:template>

	<!-- abstract -->
	<xsl:template name="abstract">
		\item Astratta:
		<xsl:if test="@isAbstract='true'">si</xsl:if>
		<xsl:if test="@isAbstract='false'">no</xsl:if>
	</xsl:template>

	<!-- namespace -->
	<xsl:template name="namespace">
		<xsl:param name="id"></xsl:param>
		
		<xsl:if test="//*[@xmi.id=$id]/@name">
			<xsl:call-template name="namespace">
				<xsl:with-param name="id" select="//*[@xmi.id=$id]/../../@xmi.id"/>
			</xsl:call-template>
			<xsl:if test="//*[@xmi.id=$id]/../../@xmi.id">::</xsl:if>
			<xsl:value-of select="//*[@xmi.id=$id]/@name"/>
		</xsl:if>

	</xsl:template>

</xsl:stylesheet>
