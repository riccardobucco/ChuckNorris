<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="text"/>
	
	<xsl:template match="/document">
		\documentclass[a4paper]{article}
		
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
		\usepackage[bookmarks=false]{hyperref}
		\usepackage[hypcap]{caption}
		\usepackage{color}
		\usepackage{eurosym}
		\usepackage{abstract}
		\usepackage{float}
		\usepackage{listings, lstautogobble}

		% per allineare il codice a sinistra invece che al centro
		\lstset{
			autogobble=true
		}

		
		

		%macro definitions
		\input{Tex/Macro.tex}
		\newcommand{\doctitle}{<xsl:value-of select="title"/>}
		\newcommand{\lastversion}{<xsl:value-of select="changes/version[1]/id"/>}
		

		%abstract font
		\renewcommand{\abstractnamefont}{\huge\bfseries}
		\renewcommand{\abstracttextfont}{\large}

		%hyperred
		\hypersetup{
			linktoc=all,
			colorlinks=true,
			allcolors=black,
			urlcolor=blue
		}

		%section counters
		\makeatletter
		\newcommand\level[1]{%
			\ifcase#1\relax\expandafter\chapter\or
				\expandafter\section\or
				\expandafter\subsection\or
				\expandafter\subsubsection\else
				\def\next{\@level{#1}}\expandafter\next
			\fi}
		\newcommand{\@level}[1]{%
			\@startsection{level#1}%
				{#1}%
				{\z@}%
				{-3.25ex\@plus -1ex \@minus -.2ex}%
				{1.5ex \@plus .2ex}%
				{\normalfont\normalsize\bfseries}}

		\newdimen\@numsdim
		\newdimen\@dotsdim
		{\normalfont\normalsize
			\sbox\z@{0}\global\@numsdim=\wd\z@
			\sbox\z@{.}\global\@dotsdim=\wd\z@
		}

		\newdimen\@numindent
		\newdimen\@textindent
		\setlength{\@numindent}{15pt}
		\setlength{\@textindent}{15pt}


		\newcounter{level4}[subsubsection]
		\@namedef{thelevel4}{\thesubsubsection.\arabic{level4}}
		\@namedef{level4mark}#1{}
		%\def\l@section{\@dottedtocline{1}{\dimexpr\@numindent*0\relax}{\dimexpr\@dotsdim*0+\@numsdim*1+\@textindent\relax}}
		\def\l@subsection{\@dottedtocline{2}{\dimexpr\@numindent*1\relax}{\dimexpr\@dotsdim*1+\@numsdim*2+\@textindent\relax}}
		\def\l@subsubsection{\@dottedtocline{3}{\dimexpr\@numindent*2\relax}{\dimexpr\@dotsdim*2+\@numsdim*3+\@textindent\relax}}
		\@namedef{l@level4}{\@dottedtocline{4}{\dimexpr\@numindent*3\relax}{\dimexpr\@dotsdim*3+\@numsdim*4+\@textindent\relax}}

		\count@=4
		\def\@ncp#1{\number\numexpr\count@+#1\relax}
		\loop\ifnum\count@&lt;100
			\begingroup\edef\x{\endgroup
				\noexpand\newcounter{level\@ncp{1}}[level\number\count@]
				\noexpand\@namedef{thelevel\@ncp{1}}{%
					\noexpand\@nameuse{thelevel\@ncp{0}}.\noexpand\arabic{level\@ncp{1}}}
				\noexpand\@namedef{level\@ncp{1}mark}####1{}%
				\noexpand\@namedef{l@level\@ncp{1}}%
					{\noexpand\@dottedtocline%
						{\@ncp{1}}%
						{\dimexpr\@numindent*\@ncp{0}\relax}%
						{\the\dimexpr\@dotsdim*\@ncp{0}+\@numsdim*\@ncp{1}+\@textindent\relax}}}%
			\x
			\advance\count@\@ne
		\repeat
		\makeatother
		
		\setcounter{tocdepth}{100}
		\setcounter{secnumdepth}{100}

		

		%fancyhdr config
		\fancyhf{}
		\fancyhead[L]{\includegraphics[scale=0.05]{Pics/Logo} \includegraphics[height=7mm]{Pics/KaizenTeam}}
		\fancyhead[R]{\Large \bfseries \doctitle \vspace{0.1mm}}

		\fancypagestyle{roman}{
			\hypersetup{linkcolor=black}
			\pagenumbering{Roman}
			\fancyfoot[C]{\thepage{}}
		}

		\fancypagestyle{plain}{
			\hypersetup{linkcolor=blue}
			\pagenumbering{arabic}
			\fancyfoot[C]{\thepage{} di \pageref*{LastPage}}
		}

		
		%space between paragraph
		\raggedbottom
		


		\begin{document}

			\pagestyle{roman}
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
			\newpage
			\pagestyle{plain}

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
