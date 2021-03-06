// Generated by view binder compiler. Do not edit!
package homework.chegg.com.chegghomework.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import homework.chegg.com.chegghomework.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemListArticleBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final TextView articleContentTv;

  @NonNull
  public final ImageView articleImageIv;

  @NonNull
  public final TextView articleTitleTv;

  private ItemListArticleBinding(@NonNull CardView rootView, @NonNull TextView articleContentTv,
      @NonNull ImageView articleImageIv, @NonNull TextView articleTitleTv) {
    this.rootView = rootView;
    this.articleContentTv = articleContentTv;
    this.articleImageIv = articleImageIv;
    this.articleTitleTv = articleTitleTv;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemListArticleBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemListArticleBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_list_article, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemListArticleBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.article_content_tv;
      TextView articleContentTv = ViewBindings.findChildViewById(rootView, id);
      if (articleContentTv == null) {
        break missingId;
      }

      id = R.id.article_image_iv;
      ImageView articleImageIv = ViewBindings.findChildViewById(rootView, id);
      if (articleImageIv == null) {
        break missingId;
      }

      id = R.id.article_title_tv;
      TextView articleTitleTv = ViewBindings.findChildViewById(rootView, id);
      if (articleTitleTv == null) {
        break missingId;
      }

      return new ItemListArticleBinding((CardView) rootView, articleContentTv, articleImageIv,
          articleTitleTv);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
