DOCUMENTI =	NormeDiProgetto \
		AnalisiDeiRequisiti \
		PianoDiProgetto \
		PianoDiQualifica


all: $(DOCUMENTI)


$(DOCUMENTI): FORCE
	@ #validazione schema
	@ xmllint --noout --schema Commons/Document.xsd $@/$@.xml

	@ #creazione file latex
	@ xsltproc -o $@/$@.tex Commons/Document.xsl $@/$@.xml

	@ #compilazione file latex
	@ make $@/$@.pdf

%.pdf:	FORCE
	@ export TEXINPUTS=":Commons/"; pdflatex -output-directory `dirname $*` `dirname $*`.tex
	@ export TEXINPUTS=":Commons/"; pdflatex -output-directory `dirname $*` `dirname $*`.tex > /dev/null
	@ export TEXINPUTS=":Commons/"; pdflatex -output-directory `dirname $*` `dirname $*`.tex > /dev/null

clean: FORCE
	@ #file latex autogenerati
	@ rm -f */*.tex
	@ #file generati da pdflatex
	@ rm -f */*.out */*.log */*.aux */*.toc */*.lof */*.lot

FORCE:
