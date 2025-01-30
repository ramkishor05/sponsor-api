package org.sponsor.form.mapper.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.sponsor.form.view.entities.onboarding.EOViewOnBoardingOptions;
import org.sponsor.form.view.entities.onboarding.EOViewOnBoardingQuestion;
import org.sponsor.form.view.mapper.ViewOnBoardingQuestionMapper;
import org.sponsor.form.view.model.onboadring.UIViewOnBoardingOptions;
import org.sponsor.form.view.model.onboadring.UIViewOnBoardingQuestion;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-29T22:45:29+0530",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class ViewOnBoardingQuestionMapperImpl implements ViewOnBoardingQuestionMapper {

    @Override
    public UIViewOnBoardingQuestion mapToDTO(EOViewOnBoardingQuestion entityObject) {
        if ( entityObject == null ) {
            return null;
        }

        UIViewOnBoardingQuestion uIViewOnBoardingQuestion = new UIViewOnBoardingQuestion();

        uIViewOnBoardingQuestion.setId( entityObject.getId() );
        uIViewOnBoardingQuestion.setOrderSequence( entityObject.getOrderSequence() );
        uIViewOnBoardingQuestion.setRecordState( entityObject.getRecordState() );
        uIViewOnBoardingQuestion.setQuestion( entityObject.getQuestion() );
        uIViewOnBoardingQuestion.setHintText( entityObject.getHintText() );
        uIViewOnBoardingQuestion.setType( entityObject.getType() );
        uIViewOnBoardingQuestion.setRequired( entityObject.isRequired() );
        uIViewOnBoardingQuestion.setOptions( eOViewOnBoardingOptionsListToUIViewOnBoardingOptionsList( entityObject.getOptions() ) );

        return uIViewOnBoardingQuestion;
    }

    @Override
    public EOViewOnBoardingQuestion mapToDAO(UIViewOnBoardingQuestion dtoObject) {
        if ( dtoObject == null ) {
            return null;
        }

        EOViewOnBoardingQuestion eOViewOnBoardingQuestion = new EOViewOnBoardingQuestion();

        eOViewOnBoardingQuestion.setId( dtoObject.getId() );
        eOViewOnBoardingQuestion.setRecordState( dtoObject.getRecordState() );
        eOViewOnBoardingQuestion.setOrderSequence( dtoObject.getOrderSequence() );
        eOViewOnBoardingQuestion.setRequired( dtoObject.isRequired() );
        eOViewOnBoardingQuestion.setQuestion( dtoObject.getQuestion() );
        eOViewOnBoardingQuestion.setHintText( dtoObject.getHintText() );
        eOViewOnBoardingQuestion.setType( dtoObject.getType() );
        eOViewOnBoardingQuestion.setOptions( uIViewOnBoardingOptionsListToEOViewOnBoardingOptionsList( dtoObject.getOptions() ) );

        return eOViewOnBoardingQuestion;
    }

    @Override
    public List<EOViewOnBoardingQuestion> mapToDAO(List<UIViewOnBoardingQuestion> dtoObjectList) {
        if ( dtoObjectList == null ) {
            return null;
        }

        List<EOViewOnBoardingQuestion> list = new ArrayList<EOViewOnBoardingQuestion>( dtoObjectList.size() );
        for ( UIViewOnBoardingQuestion uIViewOnBoardingQuestion : dtoObjectList ) {
            list.add( mapToDAO( uIViewOnBoardingQuestion ) );
        }

        return list;
    }

    @Override
    public List<UIViewOnBoardingQuestion> mapToDTO(List<EOViewOnBoardingQuestion> entityObjectList) {
        if ( entityObjectList == null ) {
            return null;
        }

        List<UIViewOnBoardingQuestion> list = new ArrayList<UIViewOnBoardingQuestion>( entityObjectList.size() );
        for ( EOViewOnBoardingQuestion eOViewOnBoardingQuestion : entityObjectList ) {
            list.add( mapToDTO( eOViewOnBoardingQuestion ) );
        }

        return list;
    }

    protected UIViewOnBoardingOptions eOViewOnBoardingOptionsToUIViewOnBoardingOptions(EOViewOnBoardingOptions eOViewOnBoardingOptions) {
        if ( eOViewOnBoardingOptions == null ) {
            return null;
        }

        UIViewOnBoardingOptions uIViewOnBoardingOptions = new UIViewOnBoardingOptions();

        uIViewOnBoardingOptions.setId( eOViewOnBoardingOptions.getId() );
        uIViewOnBoardingOptions.setOrderSequence( eOViewOnBoardingOptions.getOrderSequence() );
        uIViewOnBoardingOptions.setRecordState( eOViewOnBoardingOptions.getRecordState() );
        uIViewOnBoardingOptions.setValue( eOViewOnBoardingOptions.getValue() );
        uIViewOnBoardingOptions.setDesciption( eOViewOnBoardingOptions.getDesciption() );

        return uIViewOnBoardingOptions;
    }

    protected List<UIViewOnBoardingOptions> eOViewOnBoardingOptionsListToUIViewOnBoardingOptionsList(List<EOViewOnBoardingOptions> list) {
        if ( list == null ) {
            return null;
        }

        List<UIViewOnBoardingOptions> list1 = new ArrayList<UIViewOnBoardingOptions>( list.size() );
        for ( EOViewOnBoardingOptions eOViewOnBoardingOptions : list ) {
            list1.add( eOViewOnBoardingOptionsToUIViewOnBoardingOptions( eOViewOnBoardingOptions ) );
        }

        return list1;
    }

    protected EOViewOnBoardingOptions uIViewOnBoardingOptionsToEOViewOnBoardingOptions(UIViewOnBoardingOptions uIViewOnBoardingOptions) {
        if ( uIViewOnBoardingOptions == null ) {
            return null;
        }

        EOViewOnBoardingOptions eOViewOnBoardingOptions = new EOViewOnBoardingOptions();

        eOViewOnBoardingOptions.setId( uIViewOnBoardingOptions.getId() );
        eOViewOnBoardingOptions.setRecordState( uIViewOnBoardingOptions.getRecordState() );
        eOViewOnBoardingOptions.setOrderSequence( uIViewOnBoardingOptions.getOrderSequence() );
        eOViewOnBoardingOptions.setValue( uIViewOnBoardingOptions.getValue() );
        eOViewOnBoardingOptions.setDesciption( uIViewOnBoardingOptions.getDesciption() );

        return eOViewOnBoardingOptions;
    }

    protected List<EOViewOnBoardingOptions> uIViewOnBoardingOptionsListToEOViewOnBoardingOptionsList(List<UIViewOnBoardingOptions> list) {
        if ( list == null ) {
            return null;
        }

        List<EOViewOnBoardingOptions> list1 = new ArrayList<EOViewOnBoardingOptions>( list.size() );
        for ( UIViewOnBoardingOptions uIViewOnBoardingOptions : list ) {
            list1.add( uIViewOnBoardingOptionsToEOViewOnBoardingOptions( uIViewOnBoardingOptions ) );
        }

        return list1;
    }
}
