import { Component, OnDestroy, AfterViewInit, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-editor',
  templateUrl: './text-editor.component.html',
  styleUrls: ['./text-editor.component.css']
})
export class TextEditorComponent implements AfterViewInit, OnDestroy {
  @Input() elementId: String;
  @Output() onEditorKeyup: EventEmitter<any> = new EventEmitter<any>();
  @Input() content: String;

  editor;

  ngAfterViewInit() {
    tinymce.init({
      selector: '#' + this.elementId,
      plugins: [
        'advlist',
        'autolink',
        'lists',
        'link',
        'image ',
        'charmap',
        'print',
        'preview',
        'hr',
        'anchor',
        'pagebreak',
        'paste',
        'searchreplace',
        'wordcount',
        'visualblocks',
        'visualchars',
        'code',
        'fullscreen',
        'insertdatetime',
        'media',
        'nonbreaking',
        'save',
        'table',
        'contextmenu',
        'directionality',
        'emoticons',
        'template',
        'paste',
        'textcolor',
        'colorpicker',
        'textpattern',
        'imagetools',
        'toc'
      ],
      skin_url: '../assets/skins/lightgray',
      setup: editor => {
        this.editor = editor;
        editor.on('keyup', () => {
          const content = editor.getContent();
          this.onEditorKeyup.emit(content);
        });
        editor.on('init', () => { editor.setContent(this.content); });
      },
    });
  }

  ngOnDestroy() {
    tinymce.remove(this.editor);
  }

}
