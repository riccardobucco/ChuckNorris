DOCUMENTI =	NormeDiProgetto \
		AnalisiDeiRequisiti \
		PianoDiProgetto \
		PianoDiQualifica \
		StudioDiFattibilita

all: $(DOCUMENTI) Glossario


Glossario: FORCE
	@ #validazione schema
	@ xmllint --noout --schema Commons/Document.xsd Glossario/Glossario.xml

	@ #creazione file latex
	@ xsltproc -o Glossario/Glossario.tex Commons/Document.xsl Glossario/Glossario.xml

	@ #validazione schema
	@ xmllint --noout --schema Glossario/Termini.xsd Glossario/Termini.xml

	@ #creazione file latex
	@ xsltproc -o Glossario/Termini.tex Glossario/Termini.xsl Glossario/Termini.xml

	@ #compilazione file latex
	@ make $@/$@.pdf


$(DOCUMENTI): FORCE
	@ #validazione schema
	@ xmllint --noout --schema Commons/Document.xsd $@/$@.xml

	@ #creazione file latex
	@ xsltproc -o $@/$@.tex Commons/Document.xsl $@/$@.xml

	@ #compilazione file latex
	@ make $@/$@.pdf

%.pdf: FORCE
	@ export TEXINPUTS=":Commons/"; pdflatex -output-directory `dirname $*` `dirname $*`.tex
	@ export TEXINPUTS=":Commons/"; pdflatex -output-directory `dirname $*` `dirname $*`.tex > /dev/null
	@ export TEXINPUTS=":Commons/"; pdflatex -output-directory `dirname $*` `dirname $*`.tex > /dev/null

clean: FORCE
	@ #file latex autogenerati
	@ rm -f */*.tex
	@ #file generati da pdflatex
	@ rm -f */*.out */*.log */*.aux */*.toc */*.lof */*.lot

FORCE:
