<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="text"/>
	
	<xsl:template match="/document">
		\documentclass[a4paper,twoside]{article}
		
		%package include
		\usepackage[margin=3cm]{geometry}
		\usepackage[italian]{babel}
		\usepackage[utf8]{inputenc}
		\usepackage[T1]{fontenc}
		\usepackage{graphicx}
		\usepackage{fancyhdr}
		\usepackage{lastpage}
		\usepackage{longtable}
		\usepackage{tabu}
		\usepackage{hyperref}
		\usepackage[hypcap]{caption}
		\usepackage{color}
		\usepackage{eurosym}
		\usepackage{abstract}
		\usepackage{float}
		
		

		%macro definitions
		\input{Tex/Macro.tex}
		\newcommand{\doctitle}{<xsl:value-of select="title"/>}
		\newcommand{\lastversion}{<xsl:value-of select="changes/version[1]/id"/>}
		

		%abstract font
		\renewcommand{\abstractnamefont}{\huge\bfseries}
		\renewcommand{\abstracttextfont}{\large}

		%hyperred
		\hypersetup{linktoc=all}

		%section counters
		\setcounter{tocdepth}{5}
		\setcounter{secnumdepth}{5}

		%fancyhdr config
		\fancyhead{}
		\fancyhead[L]{\includegraphics[scale=0.05]{Pics/Logo} \includegraphics[height=7mm]{Pics/KaizenTeam}}
		\fancyhead[R]{\Large \bfseries \doctitle \vspace{0.1mm}}

		\fancyfoot{}
		\fancyfoot[C]{\thepage{} di \pageref{LastPage}}
		
		%space between paragraph
		\raggedbottom
		


		\begin{document}

			\pagestyle{fancy}
			\input{Tex/Titlepage.tex}
			\newpage
			<xsl:call-template name="description"/>
			\newpage
			<xsl:call-template name="changes"/>
			\newpage

			
			\tableofcontents
			\newpage
			\listoftables
			\newpage
			\listoffigures
			

			<xsl:apply-templates select="sections/name"/>
			<xsl:apply-templates select="appendix"/>

		\end{document}

	</xsl:template>
	
	<xsl:template name="description">

				\begin{center}
					\tabulinesep=6pt
					\begin{tabu} {X[r]|X[l]}
						\textbf{Versione} &amp; <xsl:value-of select="changes/version[1]/id"/> \\
						\textbf{Data redazione} &amp; <xsl:value-of select="changes/version[1]/date"/> \\
						\textbf{Redazione} &amp; \parbox[t]{0.4\textwidth}{<xsl:value-of select="redactedby"/>} \\
						\textbf{Verifica} &amp; \parbox[t]{0.4\textwidth}{<xsl:value-of select="verifiedby"/>} \\
						\textbf{Approvazione} &amp; \parbox[t]{0.4\textwidth}{<xsl:value-of select="approvedby"/>} \\
						\textbf{Uso} &amp; <xsl:value-of select="type"/> \\
						\textbf{Distribuzione} &amp; \parbox[t]{0.4\textwidth}{<xsl:value-of select="distribution"/>} \\
					\end{tabu}
				\end{center}

	</xsl:template>
	
	<xsl:template name="changes">
			\section*{Diario delle modifiche}
				\addtocounter{table}{-1}
				\tabulinesep=3pt
				\begin{longtabu} to \textwidth {|X[c,m]|X[c,m]|X[c,m]|X[c,m]|X[c,m]|}
					\hline
					\rowfont{\bf}
					Versione &amp;
					Data &amp;
					Autore &amp;
					Ruolo &amp;
					Descrizione \\
					\hline
					\endhead
					<xsl:for-each select="changes/version">
						<xsl:value-of select="id"/> &amp;
						<xsl:value-of select="date"/> &amp;
						<xsl:value-of select="author"/> &amp;
						<xsl:value-of select="role"/> &amp;
						<xsl:value-of select="description"/> \\
						\hline
					</xsl:for-each>
				\end{longtabu}

	</xsl:template>

	<xsl:template match="appendix">
		\appendix
		<xsl:apply-templates select="name"/>
	</xsl:template>

	<xsl:template match="name">
		\newpage
		\input{<xsl:value-of select="."/>}
	</xsl:template>
	

</xsl:stylesheet>
